package au.id.wolfe.stormcloud.core.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 * 
 * Used to persist the details of a RestMS Domain.
 * 
 */
@Entity
@Table(name = "tblDomain")
@NamedQueries( { @NamedQuery(name = "Domain.findAll", query = "SELECT d FROM Domain d") })
public class Domain implements Serializable {

    /**
     * Serial for the class
     */
    private static final long serialVersionUID = -8172498797499813958L;

    // ------------------------------------------------------------ Constructors
    /**
     * <p>
     * Construct a default {@link Domain} instance.
     * </p>
     */
    public Domain() {
    }

    // ------------------------------------------------------ Instance Variables
    private String id = ""; // Unique identifier
    private String name; // Domain name
    private String title; // Description of the domain
    private Date updated; // Last updated date/time
    private Date created; // Created date/time

    private Collection<Profile> profiles;
    private Collection<Feed> feeds;
    private Collection<Pipe> pipes;

    // -------------------------------------------------------- Property Methods
    @Id
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Column(name = "name", unique = true)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "domain")
    public Collection<Profile> getProfiles() {
        return profiles;
    }

    public void setProfiles(Collection<Profile> profiles) {
        this.profiles = profiles;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "domain")
    public Collection<Feed> getFeeds() {
        return feeds;
    }

    public void setFeeds(Collection<Feed> feeds) {
        this.feeds = feeds;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "domain")
    public Collection<Pipe> getPipes() {
        return pipes;
    }

    public void setPipes(Collection<Pipe> pipes) {
        this.pipes = pipes;
    }

    /**
     * 
     * Generate the hash code for the domain.
     *
     * NOTE: This doesn't include the data contained in collection properties.
     * 
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((created == null) ? 0 : created.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((title == null) ? 0 : title.hashCode());
        result = prime * result + ((updated == null) ? 0 : updated.hashCode());
        return result;
    }

    /**
     * 
     * Equals comparison for a domain.
     * 
     * NOTE: This doesn't include the data contained in collection properties.
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
        if (!(obj instanceof Domain)) {
            return false;
        }
        Domain other = (Domain) obj;
        if (created == null) {
            if (other.created != null) {
                return false;
            }
        } else if (!created.equals(other.created)) {
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
        if (title == null) {
            if (other.title != null) {
                return false;
            }
        } else if (!title.equals(other.title)) {
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
        return String.format("domain:{id:%s,name:%s,hashcode:%h}", id, name, this.hashCode());
    }

}
