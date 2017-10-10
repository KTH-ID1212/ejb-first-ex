/*
 * The MIT License
 *
 * Copyright 2017 Leif Lindbäck <leifl@kth.se>.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package se.kth.id1212.ejbfirstex.view;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import se.kth.id1212.ejbfirstex.model.AdderBean;

/**
 * Calls an EJB to add numbers.
 */
@Named(value = "adder")
@SessionScoped
public class Adder implements Serializable {
    @EJB
    private AdderBean adderBean;
    private int numberToAdd;

    /**
     * Returns the sum of all added numbers.
     */
    public int getTotal() {
        return adderBean.getTotal();
    }
    
    /**
     * Performs the addition.
     */
    public void add() {
        adderBean.add(numberToAdd);
    }

    /**
     * Sets the number that shall be added to the total sum.
     *
     * @param numberToAdd The number to add.
     */
    public void setNumberToAdd(Integer numberToAdd) {
        this.numberToAdd = numberToAdd;
    }

    /**
     * Always returning null clears the field where the number to add is entered by the user.
     */
    public Integer getNumberToAdd() {
        return null;
    }
}
