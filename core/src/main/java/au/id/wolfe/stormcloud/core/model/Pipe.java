package au.id.wolfe.stormcloud.core.model;

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
 * Used to persist the details of a RestMS Pipe.
 * 
 */
@Entity
@Table(name = "tblPipe")
@NamedQueries( { @NamedQuery(name = "Pipe.findAll", query = "SELECT p FROM Pipe p") })
public class Pipe {

    // ------------------------------------------------------------ Constructors

    /**
     * <p>
     * Construct a default {@link Pipe} instance.
     * </p>
     */
    public Pipe() {
    }

    // ------------------------------------------------------ Instance Variables

    private String id = ""; // Unique identifier
    private String title; // Description of the pipe
    private String type; // Feed type (direct, FIFO)
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

    @Column(name="title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name="type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Column(name="updated")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    @Column(name="created")
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
     * Generate the hash code for the pipe.
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
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((title == null) ? 0 : title.hashCode());
        result = prime * result + ((type == null) ? 0 : type.hashCode());
        result = prime * result + ((updated == null) ? 0 : updated.hashCode());
        return result;
    }

    /**
     * 
     * Equals comparison for a feed.
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
        if (!(obj instanceof Pipe)) {
            return false;
        }
        Pipe other = (Pipe) obj;
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
        if (title == null) {
            if (other.title != null) {
                return false;
            }
        } else if (!title.equals(other.title)) {
            return false;
        }
        if (type == null) {
            if (other.type != null) {
                return false;
            }
        } else if (!type.equals(other.type)) {
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
        return String.format("pipe:{id:%s,title:%s,hashcode:%h}", id, title, this.hashCode());
    }

}