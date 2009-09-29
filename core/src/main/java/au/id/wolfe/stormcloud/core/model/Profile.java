package au.id.wolfe.stormcloud.core.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 * 
 * Used to persist the details of a RestMS Profile.
 * 
 */
@Entity
@Table(name = "tblProfile")
@NamedQueries( {
        @NamedQuery(name = "Profile.findAll", query = "SELECT p FROM Profile p"),
        @NamedQuery(name = "Profile.findByDomainId", query = "SELECT p FROM Profile p WHERE p.domain.id = :domain_id") })
public class Profile implements Serializable {

    /**
     * Serial for the class
     */
    private static final long serialVersionUID = -1309048973974941634L;

    // ------------------------------------------------------------ Constructors

    /**
     * <p>
     * Construct a default {@link Profile} instance.
     * </p>
     */
    public Profile() {
    }

    // ------------------------------------------------------ Instance Variables

    private String id = ""; // Unique identifier
    private String name; // Profile name
    private String href; // profile href
    private Date updated = new Date(); // Last updated date/time
    private Date created; // Created date/time

    private Domain domain;

    // -------------------------------------------------------- Property Methods

    @Id
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Column(name="name", unique = true)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "href")
    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    @Column(name = "updated")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    @Column(name = "created")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    @ManyToOne
    @JoinColumn(name = "domain_id")
    public Domain getDomain() {
        return domain;
    }

    public void setDomain(Domain domain) {
        this.domain = domain;
    }
    
    /**
     * 
     * Generate the hash code for the profile.
     *
     * NOTE: This doesn't compare the Domain property as this is typically only set at creation.
     * 
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((created == null) ? 0 : created.hashCode());
        result = prime * result + ((href == null) ? 0 : href.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((updated == null) ? 0 : updated.hashCode());
        return result;
    }

    /**
     * 
     * Equals comparison for a profile.
     * 
     * NOTE: This doesn't compare the Domain property as this is typically only set at creation.
     * 
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Profile)) {
            return false;
        }
        Profile other = (Profile) obj;
        if (created == null) {
            if (other.created != null) {
                return false;
            }
        } else if (!created.equals(other.created)) {
            return false;
        }
        if (href == null) {
            if (other.href != null) {
                return false;
            }
        } else if (!href.equals(other.href)) {
            return false;
        }
        if (id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!id.equals(other.id)) {
            return false;
        }
        if (name == null) {
            if (other.name != null) {
                return false;
            }
        } else if (!name.equals(other.name)) {
            return false;
        }
        if (updated == null) {
            if (other.updated != null) {
                return false;
            }
        } else if (!updated.equals(other.updated)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return String.format("profile:{id:%s,name:%s,hashcode:%h}", id, name, this.hashCode());
    }

}