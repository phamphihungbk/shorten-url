import request from '../util/request';

const getURLs = (params) =>
  request({
    url: '/urls',
    method: 'get',
    params,
  });

const updateURL = (id, data) =>
  request({
    url: `/urls/${id}`,
    method: 'put',
    data,
  });

const deleteURL = (id) =>
  request({
    url: `/urls/${id}`,
    method: 'delete',
  });

const createURL = (data) =>
  request({
    url: '/url',
    method: 'post',
    data,
  });

export default { getURLs, updateURL, deleteURL, createURL };
