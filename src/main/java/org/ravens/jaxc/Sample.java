/*
 *   Copyright 2014 yatanokarasu.
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */
package org.ravens.jaxc;


import java.io.IOException;
import java.io.StringReader;

import org.ravens.jaxc.parser.CalculateParser;
import org.ravens.jaxc.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * 
 * @version v0.0.1
 * @since v0.0.1
 */
public class Sample {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(Sample.class);
    
    
    /**
     * @param args
     *            command line arguments
     * @throws ParseException
     *             parser exception
     * @throws IOException
     *             io exception
     */
    public static void main(final String... args) throws ParseException, IOException {
        Sample.LOGGER.info("calc   : " + args[0]);
        Sample.LOGGER.info("result = " + new CalculateParser(new StringReader(args[0])).calc());
    }
    
}
