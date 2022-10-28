package com.ezen.product01.Controller;

import com.ezen.product01.DTO.Product;
import com.ezen.product01.Entity.ProductEntity;
import com.ezen.product01.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

@Controller
public class FrontController {

    @Autowired
    ProductService pService;


    @GetMapping("/main")
    public String main() {
        return "top";
    }

    @GetMapping("/input")
    public String input(Product pd, Model mo) {
        mo.addAttribute("pd",new Product());
        return "in";
    }

    @PostMapping("in_save")
    public String inputSave(@ModelAttribute("pd") @Valid Product pd, BindingResult br) {
        if(br.hasErrors())        {
            return "in";
        }
        else{
            int cost=(pd.getPrice())*(pd.getCount());
            pd.setCost(cost);
            ProductEntity pEntity1=pd.toEntity();
            pService.in(pEntity1);
            return "redirect:/main";
        }

    }
/*
@GetMapping("/output")
    public String output(Model mo) {
        List<ProductEntity> list=pService.out();
        mo.addAttribute("list", list);
        return "out";
    }
*/

    @GetMapping(value = "/output")
    public String ko3(Model mo, @PageableDefault(page = 0, size = 10, sort = "id",
                        direction = Sort.Direction.DESC) Pageable pageable, String searchKeyword)    {
        Page<ProductEntity> list=null;
        if(searchKeyword == null) {
            list = pService.list(pageable);
        }else {
            list = pService.SearchList(searchKeyword, pageable);
        }
        int nowPage = list.getPageable().getPageNumber() + 1;
        int startPage = Math.max(nowPage - 4, 1);
        int endPage = Math.min(nowPage + 5, list.getTotalPages());

        mo.addAttribute("list", list);
        mo.addAttribute("nowPage", nowPage);
        mo.addAttribute("startPage", startPage);
        mo.addAttribute("endPage", endPage);
        mo.addAttribute("lista", list);
        return "out";
    }

/*
   @GetMapping("/board/list")
       public String boardList(Model model,
                               @PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.DESC) Pageable pageable,
                               String searchKeyword) {

           Page<Board> list = null;

           if(searchKeyword == null) {
               list = boardService.boardList(pageable);
           }else {
               list = boardService.boardSearchList(searchKeyword, pageable);
           }

           int nowPage = list.getPageable().getPageNumber() + 1;
           int startPage = Math.max(nowPage - 4, 1);
           int endPage = Math.min(nowPage + 5, list.getTotalPages());

           model.addAttribute("list", list);
           model.addAttribute("nowPage", nowPage);
           model.addAttribute("startPage", startPage);
           model.addAttribute("endPage", endPage);

           return "boardlist";

       }
     */

    @GetMapping("/delete")
    public String delete(@RequestParam("id") Long id) {
        pService.delete(id);
        return "redirect:/output";
    }

    @GetMapping("modify")
    public String modify(@RequestParam("id") Long id, Model mo) {
        System.out.println("id number="+id);
        ProductEntity pEntity2=pService.modify(id);
        mo.addAttribute("id",pEntity2.getId());
        mo.addAttribute("name", pEntity2.getName());
        mo.addAttribute("count", pEntity2.getCount());
        mo.addAttribute("price", pEntity2.getPrice());
        return "mod";
    }

    @PostMapping("mod_save")
    public String modSave(Product pd) {
        System.out.println("id number="+pd.getId());
        int cost=(pd.getPrice())*(pd.getCount());
        GregorianCalendar gc= new GregorianCalendar();
        pd.setCost(cost);
        ProductEntity pEntity3=pd.toEntity();
        pService.mod(pEntity3);
        return "redirect:/output";
    }

    @GetMapping("detail")
    public String detail(@RequestParam("id") Long id,Model mo) {
        pService.updateReadcnt(id);
        ProductEntity pEntity4=pService.detail(id);
        if(pEntity4!=null)
        {
            mo.addAttribute("id",pEntity4.getId());
            mo.addAttribute("name",pEntity4.getName());
            mo.addAttribute("count",pEntity4.getCount());
            mo.addAttribute("price",pEntity4.getPrice());
            mo.addAttribute("cost", pEntity4.getCost());
            mo.addAttribute("market", pEntity4.getMarket());
            mo.addAttribute("category", pEntity4.getCategory());
            mo.addAttribute("writeday", pEntity4.getWriteday());
        }

        return "detail";
    }
}
