package com.crm.database.manager;

import org.jasypt.digest.StandardStringDigester;
import org.passay.CharacterRule;
import org.passay.EnglishCharacterData;
import org.passay.PasswordGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Bohdan on 12.02.2017.
 */
public class PasswordManager
{
    private static PasswordManager instance;

    public static PasswordManager getInstance()
    {
        if (instance == null)
        {
            instance = new PasswordManager();
        }
        return instance;
    }

    StandardStringDigester digester = new StandardStringDigester();

    private PasswordGenerator passwordGenerator = new PasswordGenerator();
    private List<CharacterRule> characterRules = new ArrayList<>();

    private PasswordManager()
    {
        digester.setAlgorithm("SHA-1");
        digester.setIterations((int) Math.pow(4.0, 4.0));

        characterRules.add(new CharacterRule(EnglishCharacterData.Alphabetical));
        characterRules.add(new CharacterRule(EnglishCharacterData.Digit));
    }

    public String generatePassword(int length)
    {
        return passwordGenerator.generatePassword(length, characterRules);
    }

    public String generateNumericPassword(int length)
    {
        return passwordGenerator.generatePassword(length, Arrays.asList(new CharacterRule(EnglishCharacterData.Digit)));
    }

    public String getEncryptedPassword(String inputPassword)
    {
        return digester.digest(inputPassword);
    }

    public boolean isPasswordCorrect(String inputPassword, String encryptedPassword)
    {
        return digester.matches(inputPassword, encryptedPassword);
    }
}
