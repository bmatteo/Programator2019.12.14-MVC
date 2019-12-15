package pl.programator.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.programator.model.Bmi;
import pl.programator.services.IBmiService;

@Controller
public class BmiController {

    @Autowired
    IBmiService bmiService;

    public BmiController(IBmiService bmiService) {
        this.bmiService = bmiService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showIndex2() {
        return "redirect:/index";
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String showIndex(Model model) {
        model.addAttribute("bmiModel", new Bmi());
        return "index";
    }

    @RequestMapping(value = "/result", method = RequestMethod.POST)
    public String getForm(@ModelAttribute Bmi bmiModel, Model model) {
        double bmi = calculateBmi(bmiModel.getWeight(), bmiModel.getHeight());

        bmiModel.setBmiValue(bmi);

        this.bmiService.save(bmiModel);

        model.addAttribute("bmi", bmi);
        model.addAttribute("bmiId", bmiModel.getId());
        return "result";
    }

    @RequestMapping(value = "/findForm", method = RequestMethod.GET)
    public String findForm() {
        return "findForm";
    }

    @RequestMapping(value = "/findResult", method = RequestMethod.POST)
    public String findResult(@RequestParam int id, Model model) {
        Bmi bmi = this.bmiService.getBmiById(id);

        model.addAttribute("bmiResult", bmi);
        return "findResult";
    }

    @RequestMapping(value = "/allRecords", method = RequestMethod.GET)
    public String getAllBmi(Model model) {
        model.addAttribute("bmiList", this.bmiService.getAllBims());
        model.addAttribute("averageBmi", this.bmiService.calculateAverageBmi());
        return "allResult";
    }

    private double calculateBmi(int weight, int height) {
        double bmi = ((double) weight)
                /(((double) height)*((double) height));
        bmi = bmi * 10000;

        return ((double) Math.round(bmi * 100))/100.0;
    }
}
