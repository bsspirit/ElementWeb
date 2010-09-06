package org.conan.game.elements.web;

import org.apache.wicket.IRequestTarget;
import org.apache.wicket.RequestCycle;
import org.apache.wicket.Response;
import org.apache.wicket.markup.html.WebPage;
import org.conan.game.elements.display.InitElement;
import org.conan.game.elements.json.ReturnJSON;

public class GetInitJson extends WebPage {

    public GetInitJson() {

        InitElement init = new InitElement();
        init.init();

        ReturnJSON rtn = new ReturnJSON();
        final String json = rtn.returnInit();

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
