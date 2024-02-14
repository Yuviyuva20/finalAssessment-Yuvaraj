package com.example.assessment.controller;

import com.example.assessment.Dao.PremiumDao;
import com.example.assessment.entity.*;
import com.example.assessment.service.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/policy")
public class PolicyController {

        @Autowired
        PolicyService policyService;
        @Autowired
        AddressService addressService;
        @Autowired
        StateService stateService;
        @Autowired
        CoverageService coverageService;
        @Autowired
        PremiumService premiumService;
        @Autowired
    PremiumDao premiumDao;

        private Policy currentPolicy = new Policy();
    private List<Coverage> currentCoverage = new ArrayList<Coverage>();
    public String currentStateID;
    private int rate;
    private Policy updatePolicy ;


    @GetMapping("/list")
    public String getAll(Model model) {
        model.addAttribute("policy", policyService.getAll());
        return "view-policy";
    }


        @GetMapping("/addPolicy")
        public String addPolicy(Model model){
            Policy policyHolder = new Policy();
            List<Coverage> coverages = coverageService.getAll();
            List<State> states = stateService.getAll();
            model.addAttribute("policy",policyHolder);
            model.addAttribute("coverages",coverages);
            model.addAttribute("state",states);
            return "create-policy";
        }

        @Transactional
        @PostMapping("/save")
        public String addCoverage(@ModelAttribute("policy") Policy policy, @RequestParam("address1") String a1, @RequestParam("address2") String a2, Model  model) {
            currentPolicy.setPolicyId(policy.getPolicyId());
            currentPolicy.setHolderName(policy.getHolderName());
            Address cAddress = new Address();
            cAddress.setAddressLine1(a1);
            cAddress.setAddressLine2(a2);
            currentPolicy.setAddress(cAddress);

            policyService.save(currentPolicy);

            return "redirect:/policy/coverage";
        }

    @GetMapping("/coverage")
    public String addCoverage(Model model) {
        model.addAttribute("states", stateService.getAll());
        model.addAttribute("coverages", coverageService.getAll());
        return "create-coverage";
    }
@Transactional
    @PostMapping("/addCoverage")
    public String getCoverage(@RequestParam("coverages") String[] coverageIDs, @RequestParam("states") String state, Model model) {
        currentStateID=state;

        for(String c: coverageIDs) {
            Coverage coverage = coverageService.findById(Integer.parseInt(c));
            currentCoverage.add(coverage);
        }
     rate = policyService.getAmount(coverageIDs, currentStateID);

    model.addAttribute("preminum",rate);
    currentPolicy.setRate(rate);
        State state1 = stateService.findById(Integer.parseInt(currentStateID));
        currentPolicy.setState(state1);
        currentPolicy.setCoverageList(currentCoverage);
        currentCoverage = new ArrayList<Coverage>();
        policyService.save(currentPolicy);
        return "premium-details";
    }

    @GetMapping("/store")
    public String saveData(Model model) {
        currentPolicy.setStatus("Bound");
        policyService.save(currentPolicy);
        currentPolicy = new Policy();
        return "redirect:/policy/list";
    }
    @GetMapping("/update")
    public String updateData(@RequestParam("policyId") int id,Model model) {
        updatePolicy = policyService.findById(id);
        model.addAttribute("policy", policyService.findById(id));
        return "update";
    }
    @PostMapping("/updatepolicy")
    public String updatePolicyinfo(@ModelAttribute("policy") Policy policy,@RequestParam("address1") String a1,@RequestParam("address2") String a2, Model model) {
        currentPolicy.setPolicyId(policy.getPolicyId());
        currentPolicy.setHolderName(policy.getHolderName());
        Address cAddress = new Address();
        cAddress.setAddressLine1(a1);
        cAddress.setAddressLine2(a2);
        currentPolicy.setAddress(cAddress);
        model.addAttribute("policy", updatePolicy);
        model.addAttribute("states", stateService.getAll());
        model.addAttribute("coverages", coverageService.getAll());
        return "update-coverage";
    }

    @PostMapping("/updateCoverage")
    public String updateCoverage(@RequestParam("covs") String[] coverageIDs, @RequestParam("state") String sid,Model model) {
        currentStateID=sid;

        for(String c: coverageIDs) {
            Coverage coverage = coverageService.findById(Integer.parseInt(c));
            currentCoverage.add(coverage);
        }

        int amount = policyService.getAmount(coverageIDs, sid);

        model.addAttribute("preminum",amount);
        currentPolicy.setRate(amount);
        State state = stateService.findById(Integer.parseInt(currentStateID));
        currentPolicy.setState(state);
        currentPolicy.setCoverageList(currentCoverage);
        currentCoverage = new ArrayList<Coverage>();
        return "update-premium";
    }
    @GetMapping("/updatedPolicy")
    public String finalUpdate() {
        currentPolicy.setStatus("Bound");
        policyService.save(currentPolicy);
        currentPolicy = new Policy();
        return "redirect:/policy/list";
    }

    }





