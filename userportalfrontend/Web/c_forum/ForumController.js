myApp.controller("forumController",function($scope,$rootScope,$location,$http)
{
	$scope.forum={'forumId':0,'forumName':'','forumContent':'','createDate':'','likes':0,'loginname':'','status':''};
	
	$scope.listForumData;
	
	$scope.approvedForumList;
	
	$scope.insertForum=function()
	{
		alert("Inserting the Forum Data");
		alert("Forum Name:"+$scope.forum.forumName);
		alert("Forum Content :"+$scope.forum.forumContent);
		
		$http.post("http://localhost:8087/userportalmiddleware/addForum",$scope.forum)
		.then(function(response)
				{
					alert("Status Text:"+response.statusText);
					$location.path('/AddForum');
					
				})
	}
	
	function showForumList()
	{
		$http.get("http://localhost:8087/userportalmiddleware/listForum")
		.then(function(response)
				{
					$scope.listForumData=response.data;
					console.log($scope.listForumData);
				});
	}
	
	showForumList();
	
});