package com.spotonresponse;

import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.spotonresponse.beans.IrwinIncident;

class IrwinAttributesDeserializer implements JsonDeserializer<IrwinIncident>
{
    @Override
    public IrwinIncident deserialize(JsonElement je, Type type, JsonDeserializationContext jdc)
        throws JsonParseException
    {
        // Get the "content" element from the parsed JSON
        JsonElement incident = je.getAsJsonObject().get("attributes");

        // Deserialize it. You use a new instance of Gson to avoid infinite recursion
        // to this deserializer
        return new Gson().fromJson(incident, IrwinIncident.class);

    }
}