package org.conan.game.elements.web;

import org.apache.wicket.IRequestTarget;
import org.apache.wicket.PageParameters;
import org.apache.wicket.RequestCycle;
import org.apache.wicket.Response;
import org.apache.wicket.markup.html.WebPage;
import org.conan.game.elements.json.ReturnJSON;

public class GetEqualJson extends WebPage {

    public GetEqualJson(PageParameters params) {

        String[] leftArr = new String[] { params.getString("item1"), params.getString("item2") };

        ReturnJSON rtn = new ReturnJSON();
        final String json = rtn.returnEqual(leftArr);

        getRequestCycle().setRequestTarget(new IRequestTarget() {
            @Override
            public void detach(RequestCycle requestCycle) {
            }

            @Override
            public void respond(RequestCycle requestCycle) {
                Response response = requestCycle.getResponse();
                response.setCharacterEncoding("UTF-8");

                System.out.println(json);
                response.setContentType("application/json, text/javascript");
                response.write(json);
            }
        });

    }
}
