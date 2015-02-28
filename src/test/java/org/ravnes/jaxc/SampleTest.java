/*
 * Copyright 2014 yatanokarasu.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.ravnes.jaxc;


import java.io.StringReader;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.ravens.jaxc.parser.CalculateParser;
import org.ravens.jaxc.parser.ParseException;


/**
 * 
 * @author Yatanokarasu
 */
public final class SampleTest {
    
    private CalculateParser parser;
    
    
    /**
     * 
     */
    @Before
    public void setUp() {
        this.parser = new CalculateParser(new StringReader(""));
    }
    
    
    /**
     * 
     */
    @Test
    public void tokenNumber() {
        try {
            this.parser.ReInit(new StringReader("1;"));
            Assert.assertEquals(1, this.parser.calc());
            
            this.parser.ReInit(new StringReader("-1;"));
            Assert.assertEquals(-1, this.parser.calc());
            
            this.parser.ReInit(new StringReader("-20;"));
            Assert.assertEquals(-20, this.parser.calc());
        } catch (final ParseException exception) {
            exception.printStackTrace();
        }
    }
    
    
    /**
     * 
     */
    @Test
    public void termExpression() {
        try {
            this.parser.ReInit(new StringReader("(1);"));
            Assert.assertEquals(1, this.parser.calc());

            this.parser.ReInit(new StringReader("(-10);"));
            Assert.assertEquals(-10, this.parser.calc());

            this.parser.ReInit(new StringReader("(20);"));
            Assert.assertEquals(20, this.parser.calc());
        } catch (final ParseException exception) {
            exception.printStackTrace();
        }
    }
    
    
    /**
     * 
     */
    @Test
    public void term() {
        try {
            this.parser.ReInit(new StringReader("1+2;"));
            Assert.assertEquals(3, this.parser.calc());

            this.parser.ReInit(new StringReader("-10+5;"));
            Assert.assertEquals(-5, this.parser.calc());

            this.parser.ReInit(new StringReader("-3 - 10;"));
            Assert.assertEquals(-13, this.parser.calc());

            this.parser.ReInit(new StringReader("(-2 + 5) + 10;"));
            Assert.assertEquals(13, this.parser.calc());
        } catch (final ParseException exception) {
            exception.printStackTrace();
        }
    } 
    
}
