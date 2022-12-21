package hellojpa;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.*;

@Entity
public class Member extends BaseEntity {
    @Id
    @GeneratedValue
//    @Column(name = "MEMBER_ID")
    private Long id;

    private String name;
    private Integer age;

    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    //기간
    @Embedded
    private Period period;

    //주소
    @Embedded
    private Address address;

    @ElementCollection
    @CollectionTable(name = "FOOD", joinColumns = @JoinColumn(name = "MEMBER_ID"))
    @Column(name = "FOOD_NAME")
    private Set<String> foods = new HashSet<>();

//    @ElementCollection
//    @CollectionTable(name = "ADDRESS_LIST", joinColumns = @JoinColumn(name = "MEMBER_ID"))
//    private List<Address> addressList = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "MEMBER_ID")
    private List<AddressEntity> addressList = new ArrayList<>();


    public Set<String> getFoods() {
        return foods;
    }

    public void setFoods(Set<String> foods) {
        this.foods = foods;
    }

//    @Embedded

    public List<AddressEntity> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<AddressEntity> addressList) {
        this.addressList = addressList;
    }
//    @AttributeOverrides({
//            @AttributeOverride(name = "city", column = @Column(name = "WORK CITY")),
//                    @AttributeOverride(name = "street", column = @Column(name = "WORK STREET")),
//                            @AttributeOverride(name = "zipcode", column = @Column(name = "WORK ZIPCODE"))
//                                    })
//    private Address workAddress;

    @Lob
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TEAM_ID")
    private Team team;

    @OneToOne
    @JoinColumn(name = "LOCKER_ID")
    private Locker locker;

    @OneToMany(mappedBy = "member")
    private List<MemberProduct> memberProducts = new ArrayList<>();

    public Member() {

    }

    public Member(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public RoleType getRoleType() {
        return roleType;
    }

    public void setRoleType(RoleType roleType) {
        this.roleType = roleType;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Period getPeriod() {
        return period;
    }

    public void setPeriod(Period period) {
        this.period = period;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Locker getLocker() {
        return locker;
    }

    public void setLocker(Locker locker) {
        this.locker = locker;
    }

    public List<MemberProduct> getMemberProducts() {
        return memberProducts;
    }

    public void setMemberProducts(List<MemberProduct> memberProducts) {
        this.memberProducts = memberProducts;
    }
}
