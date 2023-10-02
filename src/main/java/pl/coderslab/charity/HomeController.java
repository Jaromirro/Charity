package pl.coderslab.charity;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.dao.InstitutionDao;
import pl.coderslab.charity.entity.Institution;
import pl.coderslab.charity.repository.DonationRepository;

import java.util.List;


@Controller
public class HomeController {

    private InstitutionDao institutionDao;

    private DonationRepository donationRepository;

    public HomeController(InstitutionDao institutionDao,
                                 DonationRepository donationRepository) {
        this.institutionDao = institutionDao;
        this.donationRepository = donationRepository;
    }

    @GetMapping("/")
    public String index(Model model){
        List<Institution> institution = institutionDao.findAll();
        model.addAttribute("institution", institution);
        model.addAttribute("donation", donationRepository.donation());
        model.addAttribute("bags", donationRepository.bags());
        return "/index";
    }
}
