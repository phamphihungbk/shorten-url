import '../util/request';

const getURLs = (params) =>
	request({
		url: '/jobs',
		method: 'get',
		params
	})

const updateURL = (id, data) =>
	request({
		url: `/jobs/${id}`,
		method: 'put',
		data
	})

const deleteURL = (id) =>
	request({
		url: `/jobs/${id}`,
		method: 'delete'
	})

const createURL = (data) =>
	request({
		url: '/url',
		method: 'post',
		data
	})

export default {getURLs, updateURL, deleteURL, createURL};
