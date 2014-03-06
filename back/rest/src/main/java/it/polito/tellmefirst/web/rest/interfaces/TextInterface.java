/**
 * TellMeFirst - A Knowledge Discovery Application
 *
 * Copyright (C) 2012 Federico Cairo, Giuseppe Futia, Federico Benedetto
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package it.polito.tellmefirst.web.rest.interfaces;

import static it.polito.tellmefirst.util.TMFUtils.unchecked;
import it.polito.tellmefirst.exception.TMFOutputException;
import it.polito.tellmefirst.util.Ret;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.codehaus.jettison.json.JSONObject;
import org.xml.sax.helpers.AttributesImpl;
import javax.xml.transform.sax.TransformerHandler;
import java.io.ByteArrayOutputStream;

/**
 * Created by IntelliJ IDEA.
 * User: Federico Cairo
 */
public class TextInterface extends AbsResponseInterface{

    static Log LOG = LogFactory.getLog(TextInterface.class);

    public String getJSON(String uri, String lang) throws Exception {
        LOG.debug("[getJSON] - BEGIN");
        String result = produceJSON( enhancer.getTitleFromDBpedia(uri, lang) );
        LOG.debug("[getJSON] - END");
        return result;
    }
    
    public static String produceJSON(final String title){
    	return unchecked(new Ret<String>() {
			public String ret() throws Exception {
				LOG.debug("producingJSON");
		    	return new JSONObject().put("Result", 
		    					new JSONObject().put("title", title)
		    				).toString();
			}
		}, "Failure in producing JSON for getMap");
    }
    
}
