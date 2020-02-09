/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isis.beecon.helpers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import java.io.IOException;
import java.util.Date;


public class DateSerializer extends StdSerializer<Date> {
	public DateSerializer() {
        this(null);
    }
   
    public DateSerializer(Class<Date> t) {
        super(t);
    }
	@Override
	public void serialize(Date t, JsonGenerator jg, SerializerProvider sp) throws IOException {
		jg.writeNumber(t.getTime());
	}
	
}
