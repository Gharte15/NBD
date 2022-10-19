package Model;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Valid
@Table(name="Client")
@Access(AccessType.FIELD)
public class Client {
    @Id
    @SequenceGenerator(initialValue = 10, name="clientIdSequence")
    @GeneratedValue(generator = "clientIdSeqence")
    private Long id;

    @NotEmpty
    private String firstName;

    @NotEmpty
    private String lastName;

    private String personalID;
    private int age;
    private boolean archive;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @NotNull
    private ClientType clientType;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    private Address address;

    public Client(String firstName, String lastName, String personalID, int age, ClientType clientType, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.personalID = personalID;
        this.age = age;
        this.clientType = clientType;
        this.address = address;
    }

    public Client() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPersonalID() {
        return personalID;
    }

    public void setPersonalID(String personalID) {
        this.personalID = personalID;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isArchive() {
        return archive;
    }

    public void setArchive(boolean archive) {
        this.archive = archive;
    }

    public ClientType getClientType() {
        return clientType;
    }

    public void setClientType(ClientType clientType) {
        this.clientType = clientType;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getClientInfo() {
        String result;
        result = "Entities.Client: " + this.getFirstName() + " " + this.getLastName() + " " + this.getPersonalID();

        if (this.address != null) {
            result += this.getAddress().getAddressInfo();
        }

        return result;
    }

    public double calculateDiscount(double price) {
        return this.clientType.applyDiscount(price);
    }

    public boolean isAdult() {
        return this.getAge() >= 18;
    }

    public int getMaxItems() {
        return this.getClientType().getMaxItems();
    }
}
