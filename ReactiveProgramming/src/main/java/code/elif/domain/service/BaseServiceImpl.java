package code.elif.domain.service;

import code.elif.domain.service.data.DataProvider;

public abstract class BaseServiceImpl {
    protected DataProvider dataProvider;

    public BaseServiceImpl(DataProvider dataProvider) {
        this.dataProvider = dataProvider;
    }
}
