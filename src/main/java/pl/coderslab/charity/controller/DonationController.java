package pl.coderslab.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.charity.dao.CategoryDao;
import pl.coderslab.charity.dao.DonationDao;
import pl.coderslab.charity.dao.InstitutionDao;
import pl.coderslab.charity.entity.Category;
import pl.coderslab.charity.entity.Donation;
import pl.coderslab.charity.entity.Institution;
import pl.coderslab.charity.repository.DonationRepository;

import javax.validation.Valid;
import java.util.List;

@Controller
public class DonationController {

    private InstitutionDao institutionDao;

    private CategoryDao categoryDao;

    private DonationDao donationDao;

    public DonationController(CategoryDao categoryDao, InstitutionDao institutionDao, DonationDao donationDao) {
        this.institutionDao = institutionDao;
        this.categoryDao = categoryDao;
        this.donationDao = donationDao;
    }

    @GetMapping("/form")
    public String showForm(Model model) {
        List<Institution> institution = institutionDao.findAll();
        model.addAttribute("institution", institution);
        model.addAttribute("category", categoryDao.findAll());
        model.addAttribute("donation", new Donation());

        return "/form";
    }

    @PostMapping("/form")
    public String processForm(@Valid @ModelAttribute("donation") Donation donation, BindingResult result){
        donationDao.save(donation);


        return "redirect:/form-confirmation";
    }
    @GetMapping("/form-confirmation")
    public String showFormConf(Model model) {
        return "/form-confirmation";
    }
}
