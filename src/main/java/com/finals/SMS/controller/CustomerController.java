package com.finals.SMS.controller;

import java.util.List;
import java.util.Optional;

import com.finals.SMS.form.CustomerForm;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.finals.SMS.entity.Customer;
import com.finals.SMS.service.CustomerService;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @GetMapping("list")
    String list(Model model) {
        List<Customer> customers = customerService.findAll();
        model.addAttribute("customers", customers);
        return "list";
    }

    //ポイント1
    @GetMapping("create")
    //ポイント2
    String create(@ModelAttribute CustomerForm customerForm) {
        return "create";
    }
    //ポイント1
    @PostMapping("create")
    //ポイント1
    String regist(@ModelAttribute @Validated CustomerForm customerForm, BindingResult result, Model model) {
        //ポイント2
        if (result.hasErrors()) {
            return create(customerForm);
        }

        Customer customer = new Customer();
        BeanUtils.copyProperties(customerForm, customer);

        customerService.insert(customer);

        return "redirect:/";
    }
    @PostMapping(path = "edit", params = "edit")
        //ポイント2
    String edit(@RequestParam Integer id, @ModelAttribute CustomerForm customerForm) {
        //ポイント3
        Optional<Customer> customerOpt = customerService.selectById(id);
        //ポイント4
        Customer customer = customerOpt.get();
        //ポイント5
        BeanUtils.copyProperties(customer, customerForm);
        return "edit";
    }
    @PostMapping(path = "edit", params = "regist")
        //ポイント2
    String regist(@RequestParam Integer id, @Validated @ModelAttribute CustomerForm customerForm, BindingResult result) {
        if (result.hasErrors()) {
            return edit(id, customerForm);
        }

        Customer customer = new Customer();
        BeanUtils.copyProperties(customerForm, customer);

        //ポイント3
        customerService.update(customer);
        return "redirect:/";
    }

    @PostMapping(path = "edit", params = "back")
    String back() {
        return "redirect:/";
    }

    @PostMapping(path = "edit", params = "delete")
    String delete(@RequestParam Integer id) {
        customerService.delete(id);
        return "redirect:/";
    }

}