package org.conan.game.elements.system;

import org.apache.wicket.Page;
import org.apache.wicket.protocol.http.WebApplication;
import org.conan.game.elements.web.GetEqualJson;
import org.conan.game.elements.web.GetInitJson;
import org.conan.game.elements.web.Homepage;

public class ElementsApp extends WebApplication {

    @Override
    public Class<? extends Page> getHomePage() {
        return Homepage.class;
    }

    @Override
    protected void init() {
        super.init();
        this.getMarkupSettings().setDefaultMarkupEncoding("utf-8");
        this.mountPagePath();
    }

    private void mountPagePath() {
        this.mountBookmarkablePage("/home", Homepage.class);
        this.mountBookmarkablePage("/json/init", GetInitJson.class);
        this.mountBookmarkablePage("/json/equal", GetEqualJson.class);

        // 1.5.0_M1
        // this.getRootRequestMapperAsCompound().add(new MountedMapper("/home", Homepage.class));
        // this.getRootRequestMapperAsCompound().add(new MountedMapper("/json/init", GetInitJson.class));
    }
}
