package service.fileReader;

import util.exception.OrderingException;

public interface FileReader  {

    public String readRulesConfigFile() throws OrderingException;
}
