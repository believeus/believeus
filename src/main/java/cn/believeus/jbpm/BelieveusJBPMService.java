package cn.believeus.jbpm;

import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import org.jbpm.JbpmConfiguration;
import org.jbpm.JbpmContext;
import org.jbpm.db.GraphSession;
import org.jbpm.graph.def.ProcessDefinition;
import org.springframework.stereotype.Service;
import org.springmodules.workflow.jbpm31.JbpmTemplate;

@Service
public class BelieveusJBPMService {
	@Resource
	private JbpmTemplate jbpmTemplate;

	public void nextStep() {
		ProcessDefinition processDefinition = jbpmTemplate
				.getProcessDefinition();
		;

	}

	public void removeProcessDefinition(String processName) {
		GraphSession graphSession = getGraphSession();
		List defs = graphSession.findAllProcessDefinitionVersions(processName);
		for (Iterator iterator = defs.iterator(); iterator.hasNext();) {
			ProcessDefinition definition = (ProcessDefinition) iterator.next();
			graphSession.deleteProcessDefinition(definition);

		}
	}
	public long addProcessInstance(String processName,int id){
		GraphSession graphSession = getGraphSession();
		ProcessDefinition definition=graphSession.findLatestProcessDefinition(processName);
		return 0;
		
	}
	private GraphSession getGraphSession(){
		JbpmConfiguration configuration = jbpmTemplate.getJbpmConfiguration();
		JbpmContext jbpmContext = configuration.getCurrentJbpmContext();
		GraphSession graphSession = jbpmContext.getGraphSession();
		return graphSession;
	}
}
