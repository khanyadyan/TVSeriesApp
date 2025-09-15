package tvseries;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

public class SeriesTest {

    @Test
    void testSearchSeries() {
        System.out.println("SearchSeries - SeriesNotFound - Test");
        List<SeriesModel> listOfSeries = new ArrayList<>();
        SeriesModel testModel = new SeriesModel();
        testModel.SeriesId = "TestId";
        testModel.SeriesName = "TestName";
        testModel.SeriesAge = "12";
        testModel.SeriesNumberOfEpisodes = "18";
        listOfSeries.add(testModel);
        Series instance = new Series(listOfSeries);
        SeriesModel result = instance.SearchSeries("WrangleIsis");
        Assertions.assertNull(result.SeriesId);
    }

    @Test
    void testSearchSeriesFound() {
        System.out.println("SearchSeries - Found - Test");
        List<SeriesModel> listOfSeries = new ArrayList<>();
        SeriesModel testModel = new SeriesModel("S1","Show","12","10");
        listOfSeries.add(testModel);
        Series instance = new Series(listOfSeries);
        SeriesModel result = instance.SearchSeries("S1");
        Assertions.assertEquals("S1", result.SeriesId);
        Assertions.assertEquals("Show", result.SeriesName);
    }

    @Test
    void testUpdateSeries() {
        System.out.println("UpdateSeries - Test");
        Series s = new Series();
        s.CaptureSeriesForTest("A1","Alpha","10","5");
        boolean updated = s.UpdateSeriesForTest("A1","Alpha2","11","6");
        Assertions.assertTrue(updated);
        SeriesModel res = s.SearchSeries("A1");
        Assertions.assertEquals("Alpha2", res.SeriesName);
        Assertions.assertEquals("11", res.SeriesAge);
        Assertions.assertEquals("6", res.SeriesNumberOfEpisodes);
    }

    @Test
    void testDeleteSeries() {
        System.out.println("DeleteSeries - Test");
        Series s = new Series();
        s.CaptureSeriesForTest("D1","Delta","12","8");
        boolean deleted = s.DeleteSeriesForTest("D1");
        Assertions.assertTrue(deleted);
        SeriesModel res = s.SearchSeries("D1");
        Assertions.assertNull(res.SeriesId);
    }

    @Test
    void testAgeValidation() {
        System.out.println("AgeValidation - Test");
        Series s = new Series();
        Assertions.assertTrue(s.isValidAge("2"));
        Assertions.assertTrue(s.isValidAge("18"));
        Assertions.assertFalse(s.isValidAge("1"));
        Assertions.assertFalse(s.isValidAge("abc"));
    }
}