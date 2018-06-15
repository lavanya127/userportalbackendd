myApp.controller("BlogController",function($scope,$http,$rootScope,$location)
{
	$scope.blog={'blogId':0,'blogContent':'','createDate':'','likes':0,'loginname':'','status':''};
	
	$scope.blogData;
	$scope.allBlogData;
	$scope.myBlogs;
	
	$scope.insertBlog=function()
	{
		console.log('Adding Blog Information');
		
		$http.post('http://localhost:8087/userportalmiddleware/addBlog',$scope.blog)
		.then(function(response)
		{
			$location.path('/blog');
		});
	}
	
	$scope.blogComment(blogid)
	{
		$rootScope.blogid=blogid;
		$location.path("/blogComment");
	}
	
	$scope.incLikes=function(blogid)
	{
		console.log('Incrment Likes');
		$http.get('http://localhost:8087/userportalmiddleware/incrementLike/'+blogid)
		.then(function(response)
				{
				$location.path('/blog');
				});
	}
	
	$scope.approve=function(blogid)
	{
		console.log('Approve the Blog');
		$http.get('http://localhost:8087/userportalmiddleware/approveBlog/'+blogid)
	};
		
	$scope.reject=function(blogid)
	{
		console.log('Reject the Blog');
		$http.get('http://localhost:8087/userportalmiddleware/rejectBlog/'+blogid)
	};
	
	function listAllBlogs()
	{
		console.log('List All Blog');
		$http.get('http://localhost:8087/userportalmiddleware/showAllApprovedBlogs')
		.then(function(response)
				{
					console.log(response.data);
					$scope.allBlogData=response.data;
				});
	}
	
	function myBlogs()
	{
		console.log('List of My Blog');
		$http.get('http://localhost:8087/userportalmiddleware/showAllBlogs')
		.then(function(response)
				{
				console.log(response.data);
				$scope.myBlogs=response.data;
				});
	}
	
	$scope.deleteBlog=function(blogid)
	{
		$http.get('http://localhost:8087/userportalmiddleware/deleteBlog/'+blogid)
		.then(function(response)
				{
				console.log(response.data);
				});
	}

	listAllBlogs();
	myBlogs();
});
		