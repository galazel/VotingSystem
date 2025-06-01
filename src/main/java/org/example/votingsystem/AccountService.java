package org.example.votingsystem;

public class AccountService {

    public boolean isAccountAlreadyExisted(VoterModel voter)
    {
        return AccountRepository.searchAccount(voter.getName(), voter.getEmail());
    }
    public boolean addAccount(VoterModel voter)
    {
        return AccountRepository.isAccountAdded(voter);
    }
    public boolean isAccountExisted(int id, String pass)
    {
        return AccountRepository.isAccountExisted(id,pass);
    }
    public int getVotersId(String name, String email)
    {
        return AccountRepository.getVotersId(name,email);
    }

    public byte[] getProfile(int id, String pass)
    {
        return AccountRepository.getVotersProfile(id, pass);
    }


}
