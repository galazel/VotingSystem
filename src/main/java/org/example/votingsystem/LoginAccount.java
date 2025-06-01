package org.example.votingsystem;

public class LoginAccount {

    private static String votersName;
    private static int votersId;
    private static byte[] profile;

    public String getVotersName() {
        return votersName;
    }

    public void setVotersName(int id) {
        votersName = AccountRepository.getVotersName(id);
    }

    public int getVotersId() {
        return votersId;
    }

    public void setVotersId(int votersId) {
        LoginAccount.votersId = votersId;
    }

    public byte[] getProfile() {
        return profile;
    }

    public void setProfile(byte[] profile) {
        LoginAccount.profile = profile;
    }
}
