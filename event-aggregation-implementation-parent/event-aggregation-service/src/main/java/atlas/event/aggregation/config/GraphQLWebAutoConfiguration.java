/*
 *  * ******************************************************************************
 *   WARNING: EXPORT CONTROLLED - EAR
 *   THESE ITEM(S) / TECHNICAL DATA CONTAIN INFORMATION SUBJECT TO U.S.
 *   GOVERNMENT EXPORT CONTROL IN ACCORDANCE WITH THE EXPORT ADMINISTRATION
 *   REGULATIONS (EAR), 15 CFR PARTS 730-774. EXPORT OF THIS DATA TO ANY
 *   FOREIGN COUNTRY OR DISCLOSURE OF THIS DATA TO ANY NON-US PERSON MAY BE A
 *   VIOLATION OF FEDERAL LAW.
 *  ******************************************************************************
 *   Unlimited Government Rights
 *   WARNING: Do Not Use On A Privately Funded Program Without Permission.
 *  ******************************************************************************
 *   CLASSIFICATION:   Unclassified
 *
 *   LIMITATIONS:      None
 *  ******************************************************************************
 */

package atlas.event.aggregation.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.LinkedHashMap;
import java.util.Map;

@Slf4j
@Configuration
@ConditionalOnWebApplication
@AutoConfigureAfter(JacksonAutoConfiguration.class)
@ConfigurationProperties(prefix = "graphql.web")
public class GraphQLWebAutoConfiguration
{

    @Value("${mapping:/graphql}")
    private String mapping;

    @Bean
    @ConditionalOnClass(CorsFilter.class)
    @ConditionalOnProperty(value = "graphql.web.corsEnabled", havingValue = "true", matchIfMissing = true)
    public CorsFilter corsConfigurer()
    {
        //log.info("Configuring Cross Domain Origin (CORS) support.");
        Map<String, CorsConfiguration> corsConfigurations = new LinkedHashMap<>(1);
        CorsConfiguration corsConfiguration = new CorsConfiguration().applyPermitDefaultValues();
        corsConfigurations.put(getCorsMapping(), corsConfiguration);

        UrlBasedCorsConfigurationSource configurationSource = new UrlBasedCorsConfigurationSource();
        configurationSource.setCorsConfigurations(corsConfigurations);
        configurationSource.setAlwaysUseFullPath(true);
        return new CorsFilter(configurationSource);
    }

    public String getMapping()
    {
        if (mapping == null)
        {
            throw new IllegalStateException("The property 'graphql.web.mapping' is undefined.");
        }
        else
        {
            return mapping;
        }
    }

    public void setMapping(String mapping)
    {
        this.mapping = mapping;
    }

    private boolean mappingIsServletWildcard()
    {
        return getMapping().endsWith("/*");
    }

    private boolean mappingIsAntWildcard()
    {
        return getMapping().endsWith("/**");
    }

    /**
     * @return the servlet mapping, coercing into an appropriate wildcard for servlets (ending in /*)
     */
    public String getServletMapping()
    {
        final String mappingString = getMapping();
        if (mappingIsAntWildcard())
        {
            return mappingString.replaceAll("\\*$", "");
        }
        else if (mappingIsServletWildcard())
        {
            return mappingString;
        }
        else
        {
            return mappingString.endsWith("/") ? mappingString + "*" : mappingString + "/*";
        }
    }

    /**
     * @return the servlet mapping, coercing into an appropriate wildcard for CORS, which uses ant matchers (ending in
     * /**)
     */
    public String getCorsMapping()
    {
        final String mappingString = getMapping();
        if (mappingIsAntWildcard())
        {
            return mappingString;
        }
        else if (mappingIsServletWildcard())
        {
            return mappingString + "*";
        }
        else
        {
            return mappingString.endsWith("/") ? mappingString + "**" : mappingString + "/**";
        }
    }
}
