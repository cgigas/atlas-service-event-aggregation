/*
 * ******************************************************************************
 *  WARNING: EXPORT CONTROLLED - EAR
 *  THESE ITEM(S) / TECHNICAL DATA CONTAIN INFORMATION SUBJECT TO U.S.
 *  GOVERNMENT EXPORT CONTROL IN ACCORDANCE WITH THE EXPORT ADMINISTRATION
 *  REGULATIONS (EAR), 15 CFR PARTS 730-774. EXPORT OF THIS DATA TO ANY
 *  FOREIGN COUNTRY OR DISCLOSURE OF THIS DATA TO ANY NON-US PERSON MAY BE A
 *  VIOLATION OF FEDERAL LAW.
 * ******************************************************************************
 *  Unlimited Government Rights
 *  WARNING: Do Not Use On A Privately Funded Program Without Permission.
 * ******************************************************************************
 *  CLASSIFICATION:   Unclassified
 *
 *  LIMITATIONS:      None
 * ******************************************************************************
 */
package atlas.event.aggregation.data.paging;

import atlas.event.aggregation.data.paging.elements.Direction;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Order
{
    public Order()
    {
        // No action
    }

    @JsonProperty("property")
    String property;
    Direction direction;

    public void setProperty(String property)
    {
        this.property = property;
    }

    public String getProperty()
    {
        return property;
    }

    public void setDirection(Direction direction)
    {
        this.direction = direction;
    }

    public Direction getDirection()
    {
        return direction;
    }

    public String toString()
    {
        return "Order {"
                + "property: " + property
                + ", "
                + "direction: " + direction
                + "}";
    }

    /**
     * Enum of field names
     */
    public static enum Field
    {
        Property("property"),
        Direction("direction");

        private String fieldName;

        Field(String fieldName)
        {
            this.fieldName = fieldName;
        }

        public String getFieldName()
        {
            return fieldName;
        }

        public Class<?> getGraphQLType()
        {
            return this.getClass().getDeclaringClass();
        }

    }

    public static Builder builder()
    {
        return new Builder();
    }



    /**
     * Builder
     */
    public static class Builder
    {
        private String property;
        private Direction direction;


        public Builder withProperty(String property)
        {
            this.property = property;
            return this;
        }
        public Builder withDirection(Direction direction)
        {
            this.direction = direction;
            return this;
        }

        public Order build()
        {
            Order _object = new Order();
            _object.setProperty(property);
            _object.setDirection(direction);
            return _object;
        }
    }
}
