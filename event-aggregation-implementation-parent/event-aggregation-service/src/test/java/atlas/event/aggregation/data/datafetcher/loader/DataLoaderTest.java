/*
 * ******************************************************************************
 *  WARNING: EXPORT CONTROLLED - EAR
 *  THESE ITEM(S) / TECHNICAL DATA CONTAIN INFORMATION SUBJECT TO U.S.
 *  GOVERNMENT EXPORT CONTROL IN ACCORDANCE WITH THE EXPORT ADMINISTRATION
 *  REGULATIONS (EAR), 15 CFR PARTS 730-774. EXPORT OF THIS DATA TO ANY
 *  FOREIGN COUNTRY OR DISCLOSURE OF THIS DATA TO ANY NON-US PERSON MAY BE A
 *  VIOLATION OF FEDERAL LAW.
 * ******************************************************************************
 *  Unlimited Government Rights
 *  WARNING: Do Not Use On A Privately Funded Program Without Permission.
 * ******************************************************************************
 *  CLASSIFICATION:   Unclassified
 *
 *  LIMITATIONS:      None
 * ******************************************************************************
 */
package atlas.event.aggregation.data.datafetcher.loader;

import atlas.event.aggregation.data.model.repository.ssaevent.SsaEventRepository;
import atlas.event.aggregation.data.model.ssaevent.Event;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import java.util.Optional;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class)
public class DataLoaderTest
{
    @Autowired
    DataLoader task;

    @Test
    public void test()
    {
        DataLoader dataLoader = ContextConfiguration.dataLoader();
        assertNotNull(dataLoader);
        dataLoader.init();
    }

    @Configuration
    public static class ContextConfiguration
    {
        @Bean
        public static DataLoader dataLoader()
        {
            SsaEventRepository ssaEventRepository = new SsaEventRepository()
            {
                @Override
                public Iterable<Event> findAll(Sort sort)
                {
                    return null;
                }

                @Override
                public Page<Event> findAll(Pageable pageable)
                {
                    return null;
                }

                @Override
                public <S extends Event> S save(S entity)
                {
                    return null;
                }

                @Override
                public <S extends Event> Iterable<S> saveAll(Iterable<S> entities)
                {
                    return null;
                }

                @Override
                public Optional<Event> findById(String s)
                {
                    return Optional.empty();
                }

                @Override
                public boolean existsById(String s)
                {
                    return false;
                }

                @Override
                public Iterable<Event> findAll()
                {
                    return null;
                }

                @Override
                public Iterable<Event> findAllById(Iterable<String> strings)
                {
                    return null;
                }

                @Override
                public long count()
                {
                    return 0;
                }

                @Override
                public void deleteById(String s)
                {

                }

                @Override
                public void delete(Event entity)
                {

                }

                @Override
                public void deleteAll(Iterable<? extends Event> entities)
                {

                }

                @Override
                public void deleteAll()
                {

                }
            };
            DataLoader dataLoader = new DataLoader(ssaEventRepository);
            return dataLoader;
        }
    }
}