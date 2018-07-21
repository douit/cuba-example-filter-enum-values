# cuba-example-filter-enum-values
CUBA example that shows how to only allow a subset of enum values

In order to filter for particular enum values, the method `setOptionsList` can be used from `LookupField` to make this happen.


## payments-edit screen

```
<fieldGroup id="fieldGroup"
            datasource="paymentsDs">
    <column width="250px">
        <field property="payingParty" custom="true"/>
        <field property="receivingParty" custom="true"/>
    </column>
</fieldGroup>
```

## PaymentsEdit controller

```
import static de.diedavids.cuba.cefev.entity.Party.*

class PaymentsEdit extends AbstractEditor<Payments> {

    @Inject FieldGroup fieldGroup
    @Inject ComponentsFactory componentsFactory
    @Inject Datasource<Payments> paymentsDs

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
```


## Resulting application

![Filter enum values](https://github.com/mariodavid/cuba-example-filter-enum-values/blob/master/img/filter-enum-values.gif)
