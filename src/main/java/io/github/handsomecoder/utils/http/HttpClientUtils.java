package io.github.handsomecoder.utils.http;

import io.github.handsomecoder.exceptions.InvalidHTTPRequestException;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

import static java.util.Objects.isNull;

/**
 * The type Http client utils.
 */
public class HttpClientUtils {


    /**
     * Get http response entity.
     *
     * @param url the url
     * @return the http response entity
     */
    public HttpResponseEntity get(String url) {

        UriBuilder builder = UriBuilder.from(url);

        HttpRequest.Builder apiBuilder = buildAPI(builder);

        return getResponse(apiBuilder.GET().build());
    }

    /**
     * Get http response entity.
     *
     * @param url         the url
     * @param queryParams the query params
     * @return the http response entity
     */
    public HttpResponseEntity get(String url, Map<String, Object> queryParams) {

        UriBuilder builder = UriBuilder.from(url)
                .addQueryParams(queryParams);

        HttpRequest.Builder apiBuilder = buildAPI(builder);

        return getResponse(apiBuilder.GET().build());
    }

    /**
     * Get http response entity.
     *
     * @param url         the url
     * @param headers     the headers
     * @param queryParams the query params
     * @return the http response entity
     */
    public HttpResponseEntity get(String url, Map<String, String> headers, Map<String, Object> queryParams) {

        UriBuilder builder = UriBuilder.from(url)
                .addQueryParams(queryParams);

        HttpRequest.Builder apiBuilder = buildAPI(headers, builder);

        return getResponse(apiBuilder.GET().build());
    }


    /**
     * Post http response entity.
     *
     * @param url the url
     * @return the http response entity
     */
    public HttpResponseEntity post(String url) {

        UriBuilder builder = UriBuilder.from(url);

        HttpRequest.Builder apiBuilder = buildAPI(builder);

        return getResponse(apiBuilder.POST(HttpRequest.BodyPublishers.noBody()).build());
    }

    /**
     * Post http response entity.
     *
     * @param url         the url
     * @param queryParams the query params
     * @return the http response entity
     */
    public HttpResponseEntity post(String url, Map<String, Object> queryParams) {

        UriBuilder builder = UriBuilder.from(url).addQueryParams(queryParams);

        HttpRequest.Builder apiBuilder = buildAPI(builder);

        return getResponse(apiBuilder.POST(HttpRequest.BodyPublishers.noBody()).build());
    }

    /**
     * Post http response entity.
     *
     * @param url     the url
     * @param headers the headers
     * @param body    the body
     * @return the http response entity
     */
    public HttpResponseEntity post(String url, Map<String, String> headers, String body) {

        UriBuilder builder = UriBuilder.from(url);

        HttpRequest.Builder apiBuilder = buildAPI(headers, builder);

        return getResponse(apiBuilder.POST(HttpRequest.BodyPublishers.ofString(body)).build());
    }

    /**
     * Post http response entity.
     *
     * @param url         the url
     * @param headers     the headers
     * @param queryParams the query params
     * @param body        the body
     * @return the http response entity
     */
    public HttpResponseEntity post(String url, Map<String, String> headers,
                                   Map<String, Object> queryParams, String body) {

        UriBuilder builder = UriBuilder.from(url)
                .addQueryParams(queryParams);

        HttpRequest.Builder apiBuilder = buildAPI(headers, builder);

        return getResponse(apiBuilder.POST(HttpRequest.BodyPublishers.ofString(body)).build());
    }


    /**
     * Put http response entity.
     *
     * @param url the url
     * @return the http response entity
     */
    public HttpResponseEntity put(String url) {

        UriBuilder builder = UriBuilder.from(url);

        HttpRequest.Builder apiBuilder = buildAPI(builder);

        return getResponse(apiBuilder.PUT(HttpRequest.BodyPublishers.noBody()).build());
    }

    /**
     * Put http response entity.
     *
     * @param url         the url
     * @param queryParams the query params
     * @return the http response entity
     */
    public HttpResponseEntity put(String url, Map<String, Object> queryParams) {

        UriBuilder builder = UriBuilder.from(url)
                .addQueryParams(queryParams);

        HttpRequest.Builder apiBuilder = buildAPI(builder);

        return getResponse(apiBuilder.PUT(HttpRequest.BodyPublishers.noBody()).build());
    }

    /**
     * Put http response entity.
     *
     * @param url     the url
     * @param headers the headers
     * @param body    the body
     * @return the http response entity
     */
    public HttpResponseEntity put(String url, Map<String, String> headers, String body) {

        UriBuilder builder = UriBuilder.from(url);

        HttpRequest.Builder apiBuilder = buildAPI(headers, builder);

        return getResponse(apiBuilder.PUT(HttpRequest.BodyPublishers.ofString(body)).build());
    }

    /**
     * Put http response entity.
     *
     * @param url         the url
     * @param headers     the headers
     * @param queryParams the query params
     * @param body        the body
     * @return the http response entity
     */
    public HttpResponseEntity put(String url, Map<String, String> headers,
                                  Map<String, Object> queryParams, String body) {

        UriBuilder builder = UriBuilder.from(url)
                .addQueryParams(queryParams);

        HttpRequest.Builder apiBuilder = buildAPI(headers, builder);

        return getResponse(apiBuilder.PUT(HttpRequest.BodyPublishers.ofString(body)).build());
    }


    /**
     * Delete http response entity.
     *
     * @param url the url
     * @return the http response entity
     */
    public HttpResponseEntity delete(String url) {

        UriBuilder builder = UriBuilder.from(url);

        HttpRequest.Builder apiBuilder = buildAPI(builder);

        return getResponse(apiBuilder.DELETE().build());
    }

    /**
     * Delete http response entity.
     *
     * @param url         the url
     * @param queryParams the query params
     * @return the http response entity
     */
    public HttpResponseEntity delete(String url, Map<String, Object> queryParams) {

        UriBuilder builder = UriBuilder.from(url);

        HttpRequest.Builder apiBuilder = buildAPI(builder);

        return getResponse(apiBuilder.DELETE().build());
    }

    /**
     * Delete http response entity.
     *
     * @param url         the url
     * @param headers     the headers
     * @param queryParams the query params
     * @return the http response entity
     */
    public HttpResponseEntity delete(String url, Map<String, String> headers, Map<String, Object> queryParams) {

        UriBuilder builder = UriBuilder.from(url)
                .addQueryParams(queryParams);

        HttpRequest.Builder apiBuilder = buildAPI(headers, builder);

        return getResponse(apiBuilder.DELETE().build());
    }


    private HttpResponseEntity getResponse(HttpRequest request) {
        HttpResponse<String> response = null;

        try {
            response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new InvalidHTTPRequestException(e.getMessage());
        }

        if (isNull(response)) {
            return HttpResponseEntity.getEmptyResponse();
        }

        return new HttpResponseEntity(response.statusCode(), response.body());
    }

    private HttpRequest.Builder buildAPI(UriBuilder builder) {
        return HttpRequest.newBuilder(builder.build());
    }

    private HttpRequest.Builder buildAPI(Map<String, String> headers, UriBuilder builder) {
        HttpRequest.Builder apiBuilder = buildAPI(builder);

        if (isNull(headers) || headers.isEmpty()) {
            return apiBuilder;
        }

        for (Map.Entry<String, String> header : headers.entrySet()) {
            apiBuilder.header(header.getKey(), header.getValue());
        }
        return apiBuilder;
    }

}
