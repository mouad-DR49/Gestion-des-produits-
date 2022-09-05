package com.modui.web;


import com.modui.dao.ProduitRepository;
import com.modui.entities.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProduitController {
    @Autowired
    private ProduitRepository produitRepository;

    @GetMapping("/index")
    public String chercher(Model model,
                           @RequestParam(name = "page", defaultValue = "0") int page,
                           @RequestParam(name = "motCle", defaultValue = "") String mc) {
        Page<Produit> pageProduits =
                produitRepository.findByDesignationContainsIgnoreCase(mc, PageRequest.of(page, 5));


        model.addAttribute("listproduits", pageProduits.getContent());
        model.addAttribute("pages", new int[pageProduits.getTotalPages()]);
        model.addAttribute("currentPage", page);
        model.addAttribute("motCle", mc);
        return "produits";
    }

    @GetMapping("/delete")
    public String delete(Long id, int page, String motCle) {

        produitRepository.deleteById(id);
        return "redirect:/index?page=" + page + "&motCle=" + motCle;
    }

}
