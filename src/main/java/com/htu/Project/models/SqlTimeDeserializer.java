package com.htu.Project.models;

import java.io.IOException;
import java.sql.Time;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class SqlTimeDeserializer extends JsonDeserializer<Time> {
	@Override
	public Time deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		// TODO Auto-generated method stub
		return Time.valueOf(p.getValueAsString() + ":00");
	}
}

/*<!DOCTYPE html>
<html>
<body>

<h1>Show a Time Input Control</h1>

<p>If the browser supports it, a time picker pops up when entering the input field.</p>

<form action="/action_page.php">
  <label for="appt">Select a time:</label>
  <input type="time" id="appt" name="appt">
  <input type="submit">
</form>

<p><strong>Note:</strong> type="time" is not supported in Safari or Internet Explorer 12 and earlier versions.</p>

</body>
</html>
*/