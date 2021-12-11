package springadvanced.exam.service;

import springadvanced.exam.model.view.StatsView;

public interface StatsService {

    void onRequest();
    StatsView getStats();

}
