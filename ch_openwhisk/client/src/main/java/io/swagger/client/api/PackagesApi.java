/*
 * OpenWhisk REST API
 * API for OpenWhisk
 *
 * OpenAPI spec version: 0.1.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package io.swagger.client.api;

import io.swagger.client.ApiCallback;
import io.swagger.client.ApiClient;
import io.swagger.client.ApiException;
import io.swagger.client.ApiResponse;
import io.swagger.client.Configuration;
import io.swagger.client.Pair;
import io.swagger.client.ProgressRequestBody;
import io.swagger.client.ProgressResponseBody;

import com.google.gson.reflect.TypeToken;

import java.io.IOException;


import io.swagger.client.model.EntityBrief;
import io.swagger.client.model.ErrorMessage;
import io.swagger.client.model.ItemId;
import io.swagger.client.model.ModelPackage;
import io.swagger.client.model.PackagePut;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PackagesApi {
    private ApiClient apiClient;

    public PackagesApi() {
        this(Configuration.getDefaultApiClient());
    }

    public PackagesApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Build call for deletePackage
     * @param namespace The entity namespace (required)
     * @param packageName Name of package (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call deletePackageCall(String namespace, String packageName, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/namespaces/{namespace}/packages/{packageName}"
            .replaceAll("\\{" + "namespace" + "\\}", apiClient.escapeString(namespace.toString()))
            .replaceAll("\\{" + "packageName" + "\\}", apiClient.escapeString(packageName.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "DELETE", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call deletePackageValidateBeforeCall(String namespace, String packageName, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'namespace' is set
        if (namespace == null) {
            throw new ApiException("Missing the required parameter 'namespace' when calling deletePackage(Async)");
        }
        
        // verify the required parameter 'packageName' is set
        if (packageName == null) {
            throw new ApiException("Missing the required parameter 'packageName' when calling deletePackage(Async)");
        }
        
        
        com.squareup.okhttp.Call call = deletePackageCall(namespace, packageName, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Delete a package
     * Delete a package
     * @param namespace The entity namespace (required)
     * @param packageName Name of package (required)
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public void deletePackage(String namespace, String packageName) throws ApiException {
        deletePackageWithHttpInfo(namespace, packageName);
    }

    /**
     * Delete a package
     * Delete a package
     * @param namespace The entity namespace (required)
     * @param packageName Name of package (required)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Void> deletePackageWithHttpInfo(String namespace, String packageName) throws ApiException {
        com.squareup.okhttp.Call call = deletePackageValidateBeforeCall(namespace, packageName, null, null);
        return apiClient.execute(call);
    }

    /**
     * Delete a package (asynchronously)
     * Delete a package
     * @param namespace The entity namespace (required)
     * @param packageName Name of package (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call deletePackageAsync(String namespace, String packageName, final ApiCallback<Void> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = deletePackageValidateBeforeCall(namespace, packageName, progressListener, progressRequestListener);
        apiClient.executeAsync(call, callback);
        return call;
    }
    /**
     * Build call for getAlPackages
     * @param namespace The entity namespace (required)
     * @param _public Include publicly shared entitles in the result. (optional)
     * @param limit Number of entities to include in the result. (optional)
     * @param skip Number of entities to skip in the result. (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call getAlPackagesCall(String namespace, Boolean _public, Integer limit, Integer skip, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/namespaces/{namespace}/packages"
            .replaceAll("\\{" + "namespace" + "\\}", apiClient.escapeString(namespace.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        if (_public != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "public", _public));
        if (limit != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "limit", limit));
        if (skip != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "skip", skip));

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getAlPackagesValidateBeforeCall(String namespace, Boolean _public, Integer limit, Integer skip, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'namespace' is set
        if (namespace == null) {
            throw new ApiException("Missing the required parameter 'namespace' when calling getAlPackages(Async)");
        }
        
        
        com.squareup.okhttp.Call call = getAlPackagesCall(namespace, _public, limit, skip, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Get all packages
     * Get all packages
     * @param namespace The entity namespace (required)
     * @param _public Include publicly shared entitles in the result. (optional)
     * @param limit Number of entities to include in the result. (optional)
     * @param skip Number of entities to skip in the result. (optional)
     * @return List&lt;EntityBrief&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public List<EntityBrief> getAlPackages(String namespace, Boolean _public, Integer limit, Integer skip) throws ApiException {
        ApiResponse<List<EntityBrief>> resp = getAlPackagesWithHttpInfo(namespace, _public, limit, skip);
        return resp.getData();
    }

    /**
     * Get all packages
     * Get all packages
     * @param namespace The entity namespace (required)
     * @param _public Include publicly shared entitles in the result. (optional)
     * @param limit Number of entities to include in the result. (optional)
     * @param skip Number of entities to skip in the result. (optional)
     * @return ApiResponse&lt;List&lt;EntityBrief&gt;&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<List<EntityBrief>> getAlPackagesWithHttpInfo(String namespace, Boolean _public, Integer limit, Integer skip) throws ApiException {
        com.squareup.okhttp.Call call = getAlPackagesValidateBeforeCall(namespace, _public, limit, skip, null, null);
        Type localVarReturnType = new TypeToken<List<EntityBrief>>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Get all packages (asynchronously)
     * Get all packages
     * @param namespace The entity namespace (required)
     * @param _public Include publicly shared entitles in the result. (optional)
     * @param limit Number of entities to include in the result. (optional)
     * @param skip Number of entities to skip in the result. (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getAlPackagesAsync(String namespace, Boolean _public, Integer limit, Integer skip, final ApiCallback<List<EntityBrief>> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = getAlPackagesValidateBeforeCall(namespace, _public, limit, skip, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<List<EntityBrief>>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for getPackageByName
     * @param namespace The entity namespace (required)
     * @param packageName Name of package to fetch (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call getPackageByNameCall(String namespace, String packageName, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/namespaces/{namespace}/packages/{packageName}"
            .replaceAll("\\{" + "namespace" + "\\}", apiClient.escapeString(namespace.toString()))
            .replaceAll("\\{" + "packageName" + "\\}", apiClient.escapeString(packageName.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getPackageByNameValidateBeforeCall(String namespace, String packageName, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'namespace' is set
        if (namespace == null) {
            throw new ApiException("Missing the required parameter 'namespace' when calling getPackageByName(Async)");
        }
        
        // verify the required parameter 'packageName' is set
        if (packageName == null) {
            throw new ApiException("Missing the required parameter 'packageName' when calling getPackageByName(Async)");
        }
        
        
        com.squareup.okhttp.Call call = getPackageByNameCall(namespace, packageName, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Get package information
     * Get package information.
     * @param namespace The entity namespace (required)
     * @param packageName Name of package to fetch (required)
     * @return ModelPackage
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ModelPackage getPackageByName(String namespace, String packageName) throws ApiException {
        ApiResponse<ModelPackage> resp = getPackageByNameWithHttpInfo(namespace, packageName);
        return resp.getData();
    }

    /**
     * Get package information
     * Get package information.
     * @param namespace The entity namespace (required)
     * @param packageName Name of package to fetch (required)
     * @return ApiResponse&lt;ModelPackage&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<ModelPackage> getPackageByNameWithHttpInfo(String namespace, String packageName) throws ApiException {
        com.squareup.okhttp.Call call = getPackageByNameValidateBeforeCall(namespace, packageName, null, null);
        Type localVarReturnType = new TypeToken<ModelPackage>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Get package information (asynchronously)
     * Get package information.
     * @param namespace The entity namespace (required)
     * @param packageName Name of package to fetch (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getPackageByNameAsync(String namespace, String packageName, final ApiCallback<ModelPackage> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = getPackageByNameValidateBeforeCall(namespace, packageName, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<ModelPackage>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for updatePackage
     * @param namespace The entity namespace (required)
     * @param packageName Name of package (required)
     * @param _package The package being updated (required)
     * @param overwrite Overwrite item if it exists. Default is false. (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call updatePackageCall(String namespace, String packageName, PackagePut _package, String overwrite, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = _package;
        
        // create path and map variables
        String localVarPath = "/namespaces/{namespace}/packages/{packageName}"
            .replaceAll("\\{" + "namespace" + "\\}", apiClient.escapeString(namespace.toString()))
            .replaceAll("\\{" + "packageName" + "\\}", apiClient.escapeString(packageName.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        if (overwrite != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "overwrite", overwrite));

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "PUT", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call updatePackageValidateBeforeCall(String namespace, String packageName, PackagePut _package, String overwrite, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'namespace' is set
        if (namespace == null) {
            throw new ApiException("Missing the required parameter 'namespace' when calling updatePackage(Async)");
        }
        
        // verify the required parameter 'packageName' is set
        if (packageName == null) {
            throw new ApiException("Missing the required parameter 'packageName' when calling updatePackage(Async)");
        }
        
        // verify the required parameter '_package' is set
        if (_package == null) {
            throw new ApiException("Missing the required parameter '_package' when calling updatePackage(Async)");
        }
        
        
        com.squareup.okhttp.Call call = updatePackageCall(namespace, packageName, _package, overwrite, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Create or update a package
     * Create or update a package
     * @param namespace The entity namespace (required)
     * @param packageName Name of package (required)
     * @param _package The package being updated (required)
     * @param overwrite Overwrite item if it exists. Default is false. (optional)
     * @return ItemId
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ItemId updatePackage(String namespace, String packageName, PackagePut _package, String overwrite) throws ApiException {
        ApiResponse<ItemId> resp = updatePackageWithHttpInfo(namespace, packageName, _package, overwrite);
        return resp.getData();
    }

    /**
     * Create or update a package
     * Create or update a package
     * @param namespace The entity namespace (required)
     * @param packageName Name of package (required)
     * @param _package The package being updated (required)
     * @param overwrite Overwrite item if it exists. Default is false. (optional)
     * @return ApiResponse&lt;ItemId&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<ItemId> updatePackageWithHttpInfo(String namespace, String packageName, PackagePut _package, String overwrite) throws ApiException {
        com.squareup.okhttp.Call call = updatePackageValidateBeforeCall(namespace, packageName, _package, overwrite, null, null);
        Type localVarReturnType = new TypeToken<ItemId>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Create or update a package (asynchronously)
     * Create or update a package
     * @param namespace The entity namespace (required)
     * @param packageName Name of package (required)
     * @param _package The package being updated (required)
     * @param overwrite Overwrite item if it exists. Default is false. (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call updatePackageAsync(String namespace, String packageName, PackagePut _package, String overwrite, final ApiCallback<ItemId> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = updatePackageValidateBeforeCall(namespace, packageName, _package, overwrite, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<ItemId>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
}
