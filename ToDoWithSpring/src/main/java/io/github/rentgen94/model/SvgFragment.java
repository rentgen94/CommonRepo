package io.github.rentgen94.model;

import java.util.HashMap;

public class SvgFragment {
    private String templateName;
    private String fragmentName;
    private HashMap<String, String> arguments;
	private Role role;

    public SvgFragment(String templateName, String fragmentName, HashMap<String, String> arguments) {
        this.templateName = templateName;
        this.fragmentName = fragmentName;
        this.arguments = arguments;
    }

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    public String getFragmentName() {
        return fragmentName;
    }

    public void setFragmentName(String fragmentName) {
        this.fragmentName = fragmentName;
    }

    public HashMap<String, String> getArguments() {
        return arguments;
    }

    public void setArguments(HashMap<String, String> arguments) {
        this.arguments = arguments;
    }
}
