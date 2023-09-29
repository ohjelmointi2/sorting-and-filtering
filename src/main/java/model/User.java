package model;

public class User {
    private final long id;
    private final String firstName;
    private final String lastName;
    private final String age;
    private final String gender;
    private final String email;
    private final String phone;
    private final String username;
    private final String password;
    private final String birthDate;
    private final String image;
    private final String ip;
    private final String ssn;
    private final String userAgent;

    /**
     * Users who registered through our mobile app have an integer value
     * representing the epoch timestamp in seconds, while users who registered
     * through the web app have a string in ISO format.
     */
    private final String registeredAt;

    public User(long id, String firstName, String lastName, String age, String gender, String email, String phone,
            String username, String password, String birthDate, String image, String ip, String ssn, String userAgent,
            String registeredAt) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
        this.email = email;
        this.phone = phone;
        this.username = username;
        this.password = password;
        this.birthDate = birthDate;
        this.image = image;
        this.ip = ip;
        this.ssn = ssn;
        this.userAgent = userAgent;
        this.registeredAt = registeredAt;
    }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getImage() {
        return image;
    }

    public String getIp() {
        return ip;
    }

    public String getSsn() {
        return ssn;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public String getRegisteredAt() {
        return registeredAt;
    }

}
