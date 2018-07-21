package de.diedavids.cuba.cefev.web.payments

import com.haulmont.cuba.gui.components.AbstractEditor
import com.haulmont.cuba.gui.components.FieldGroup
import com.haulmont.cuba.gui.components.LookupField
import com.haulmont.cuba.gui.data.Datasource
import com.haulmont.cuba.gui.xml.layout.ComponentsFactory
import de.diedavids.cuba.cefev.entity.Party
import de.diedavids.cuba.cefev.entity.Payments

import javax.inject.Inject

import static de.diedavids.cuba.cefev.entity.Party.*

class PaymentsEdit extends AbstractEditor<Payments> {

    @Inject
    protected FieldGroup fieldGroup

    @Inject
    protected ComponentsFactory componentsFactory

    @Inject
    protected Datasource<Payments> paymentsDs

    @Override
    void init(Map<String, Object> params) {
        initPartyAttribute("payingParty", [EMPLOYEE, COMPANY])
        initPartyAttribute("receivingParty", [EMPLOYEE, COMPANY, OTHER])
    }

    protected void initPartyAttribute(String attribute, List<Party> partyOptions) {
        FieldGroup.FieldConfig payingPartyFieldConfig = fieldGroup.getField(attribute)
        LookupField lookupComponent = componentsFactory.createComponent(LookupField.NAME) as LookupField
        lookupComponent.setDatasource(paymentsDs, attribute)
        lookupComponent.optionsList = partyOptions
        payingPartyFieldConfig.component = lookupComponent
    }


}