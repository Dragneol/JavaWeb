/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacific.struts;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import java.util.Map;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.apache.struts2.convention.annotation.Results;
import pacific.daos.PilotDAO;
import pacific.dtos.PilotDTO;

/**
 *
 * @author DuongPTHSE62871
 */
@ResultPath("/pilot/")
@Results(
        @Result(name = "success", location = "index.jsp"))
public class PilotViewAction extends ActionSupport {

    public PilotViewAction() {
    }

    public String execute() throws Exception {
        Map session = ActionContext.getContext().getSession();
        PilotDTO dto = (PilotDTO) session.get("AUTHORIZED");
        PilotDAO dao = new PilotDAO();
        List<PilotDTO> list = dao.findByTeam(dto.getGroupCode(), dto.getUsername());
        session.put("PARTNER", list);
        String jeager = dao.getRiderTeam(dto.getUsername(), dto.getGroupCode());
        session.put("JEAGER", jeager);
        return SUCCESS;
    }

}
