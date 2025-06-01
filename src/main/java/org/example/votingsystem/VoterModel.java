package org.example.votingsystem;

public class VoterModel
{
    private String name, email, contactNum, password;
    private byte[] profile;

    private VoterModel(Builder builder)
    {
        this.name = builder.name;
        this.email = builder.email;
        this.contactNum = builder.contactNum;
        this.password = builder.password;
        this.profile = builder.profile;
    }

    public static class Builder
    {
        private String name, email, contactNum, password;
        private byte[] profile;

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setContactNum(String contactNum) {
            this.contactNum = contactNum;
            return this;
        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }
        public Builder setProfile(byte[] profile) {
            this.profile = profile;
            return this;
        }
        public VoterModel build()
        {
            return new VoterModel(this);
        }
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getContactNum() {
        return contactNum;
    }

    public String getPassword() {
        return password;
    }
    public byte[] getProfile() {
        return profile;
    }
}
