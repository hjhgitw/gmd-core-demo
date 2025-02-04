/*
 * #%L
 * GwtMaterial
 * %%
 * Copyright (C) 2015 - 2017 GwtMaterialDesign
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
package gmd.core.demo.client.application.page.loaders;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;
import gwt.material.design.client.constants.Blur;
import gwt.material.design.client.constants.Color;
import gwt.material.design.client.constants.LoaderType;
import gwt.material.design.client.constants.OverlayOption;
import gwt.material.design.client.constants.ProgressType;
import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialCard;
import gwt.material.design.client.ui.MaterialCardContent;
import gwt.material.design.client.ui.MaterialCheckBox;
import gwt.material.design.client.ui.MaterialLoader;
import gwt.material.design.client.ui.MaterialNavBar;

import javax.inject.Inject;

import static gwt.material.design.jquery.client.api.JQuery.$;

public class LoadersView extends ViewImpl implements LoadersPresenter.MyView {
    interface Binder extends UiBinder<Widget, LoadersView> {
    }

    @UiField
    MaterialNavBar navBar;

    @UiField
    MaterialCard loaderCard;

    @UiField
    MaterialCardContent cardContent;

    @UiField
    MaterialButton btnLoader, btnProgress;

    @UiField
    MaterialCheckBox loaderWithMessage, loaderWithBackground, loaderWithBlur, loaderWithOpacity, loaderWithoutScrolling;

    @Inject
    LoadersView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
    }

    @UiHandler("btnLoader")
    void onShowLoaderSpecific(ClickEvent e) {
        MaterialLoader.loading(true, loaderCard);
        btnProgress.setEnabled(false);
        Timer timer = new Timer() {
            @Override
            public void run() {
                btnProgress.setEnabled(true);
                MaterialLoader.loading(false);
            }
        };
        timer.schedule(2000);
    }

    @UiHandler("btnProgress")
    void onShowProgressSpecific(ClickEvent e) {
        MaterialLoader.progress(true, cardContent);
        btnLoader.setEnabled(false);
        Timer timer = new Timer() {
            @Override
            public void run() {
                btnLoader.setEnabled(true);
                MaterialLoader.progress(false);
            }
        };
        timer.schedule(2000);
    }

    @UiHandler("btnShowLoader")
    void onShowLoader(ClickEvent e) {
        MaterialLoader loader = new MaterialLoader();
        loader.setType(LoaderType.CIRCULAR);

        OverlayOption option = OverlayOption.create();
        if (loaderWithBackground.getValue()) {
            option.setBackgroundColor(Color.BLUE);
        }

        if (loaderWithBlur.getValue()) {
            option.setBlur(new Blur(4, $("#app-container")));
        }

        if (loaderWithOpacity.getValue()) {
            option.setOpacity(1.0);
        }

        loader.setMessage(loaderWithMessage.getValue() ? "Please Wait" : "");

        loader.setOverlayOption(option);
        loader.setScrollDisabled(loaderWithoutScrolling.getValue());
        loader.show();
        Timer t = new Timer() {
            @Override
            public void run() {
                loader.hide();
            }
        };
        t.schedule(3000);
    }

    @UiHandler("btnShowProgress")
    void onShowProgress(ClickEvent e) {
        MaterialLoader.progress(true);
        Timer t = new Timer() {
            @Override
            public void run() {
                MaterialLoader.progress(false);
            }
        };
        t.schedule(3000);
    }

    @UiHandler("btnShowNavBarProgress")
    void onShowNavBarProgress(ClickEvent e) {
        navBar.showProgress(ProgressType.INDETERMINATE);
        Timer t = new Timer() {
            @Override
            public void run() {
                navBar.hideProgress();
            }
        };
        t.schedule(3000);
    }
}
