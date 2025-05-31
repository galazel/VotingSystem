package org.example.votingsystem;

public class LoginAccount {

    public static String votersName;
    public static int votersId;

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
}
