/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package samples.struts;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.apache.struts2.convention.annotation.Results;

/**
 *
 * @author DuongPTHSE62871
 */
@ResultPath("/")
@Results(
        @Result(location = "/index.jsp", name = "success")
)
public class TestAction extends ActionSupport {

    private String test;

    public TestAction() {
    }

    public String execute() throws Exception {
        System.out.println(test);
        return "success";
    }

    /**
     * @return the test
     */
    public String getTest() {
        return test;
    }

    /**
     * @param test the test to set
     */
    public void setTest(String test) {
        this.test = test;
    }

}
