
package com.example.spaceflightnews.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
//import org.apache.commons.lang.builder.EqualsBuilder;
//import org.apache.commons.lang.builder.HashCodeBuilder;
//import org.apache.commons.lang.builder.ToStringBuilder;

public class Launch {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("provider")
    @Expose
    private String provider;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

  /*  @Override
    public String toString() {
        return new ToStringBuilder(this).append("id", id).append("provider", provider).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(provider).append(id).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Launch) == false) {
            return false;
        }
        Launch rhs = ((Launch) other);
        return new EqualsBuilder().append(provider, rhs.provider).append(id, rhs.id).isEquals();
    }
*/
}
