package com.ferpateste.controllers;

import com.ferpateste.exceptions.UnsupportedMathOperationException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/math")
public class MathController {

    //http://localhost:8080/math/sum/3/5
    @RequestMapping("/sum/{n1}/{n2}")
    public Double sum(@PathVariable("n1") String n1,
                      @PathVariable("n2") String n2) {
        if(!isNumeric(n1) || !isNumeric(n2)) throw new UnsupportedMathOperationException("Set a numeric value");
        return convertToDouble(n1) + convertToDouble(n2);
    }

    //http://localhost:8080/math/subtract/3/5
    @RequestMapping("/subtract/{n1}/{n2}")
    public Double subtract(@PathVariable("n1") String n1,
                      @PathVariable("n2") String n2) {
        if(!isNumeric(n1) || !isNumeric(n2)) throw new UnsupportedMathOperationException("Set a numeric value");
        return convertToDouble(n1) - convertToDouble(n2);
    }

    //http://localhost:8080/math/divide/3/5
    @RequestMapping("/divide/{n1}/{n2}")
    public Double divide(@PathVariable("n1") String n1,
                           @PathVariable("n2") String n2) {
        if(!isNumeric(n1) || !isNumeric(n2)) throw new UnsupportedMathOperationException("Set a numeric value");
        return convertToDouble(n1) / convertToDouble(n2);
    }

    //http://localhost:8080/math/multiply/3/5
    @RequestMapping("/multiply/{n1}/{n2}")
    public Double multiply(@PathVariable("n1") String n1,
                         @PathVariable("n2") String n2) {
        if(!isNumeric(n1) || !isNumeric(n2)) throw new UnsupportedMathOperationException("Set a numeric value");
        return convertToDouble(n1) * convertToDouble(n2);
    }

    //http://localhost:8080/math/media/3/5
    @RequestMapping("/media/{n1}/{n2}")
    public Double media(@PathVariable("n1") String n1,
                           @PathVariable("n2") String n2) {
        if(!isNumeric(n1) || !isNumeric(n2)) throw new UnsupportedMathOperationException("Set a numeric value");
        return (convertToDouble(n1) + convertToDouble(n2)) / 2;
    }

    //http://localhost:8080/math/raizQuadrada/144
    @RequestMapping("/raizQuadrada/{n1}")
    public Double raizQuadrada(@PathVariable("n1") String n1) {
        if(!isNumeric(n1)) throw new UnsupportedMathOperationException("Set a numeric value");
        return Math.sqrt(convertToDouble(n1));
    }




    private Double convertToDouble(String value){
        return Double.parseDouble(value);
    }

    private boolean isNumeric(String strnumber) {
        if(strnumber == null || strnumber.isEmpty()){ return false; }
        String number = strnumber.replace(",", ".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]");

    }


}
