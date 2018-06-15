myApp.controller("BlogCommentController",function($scope,$http,$rootScope,$location)
{
	$scope.blogCommentData;
	$scope.blogData;
	
	function listMyBlogComment()
	{
		$http.get

('http://localhost:8087/userportalmiddleware/listAllBlogComments/'+$rootScope.blogid)
		.then(function(response)
				{
					

$rootScope.blogCommentData=response.data;
					$rootScope.blogId=blogId;
					$location.path("/blogComment");
				});
	}
	
	function myBlog()
	{
		
	}
	
	myyBlog();
	
	listMyBlogComment();
});