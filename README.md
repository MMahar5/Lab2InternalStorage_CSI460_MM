# Lab2InternalStorage_CSI460_MM


 I decided to create a to-do list to demonstrate the use of internal storage. However, it doesn't work exactly like a traditional to-do list application because the purpose is to show it write and read the information from a .txt file within the internal storage of a phone.

This is the basic presentation for the app. It has an edit text line and "Add to List" button where the user can add items to a To-Do list that gets shown in a recycler view below. I already added a few items as you can see.
![Capture](https://github.com/MMahar5/Lab2InternalStorage_CSI460_MM/assets/97249776/9155c615-1290-4897-abee-980b86778c5f)

Here you can see within the device explorer, a file named "todo_list.txt" that is in the internal storage with the list items that are currently added.
![Capture2](https://github.com/MMahar5/Lab2InternalStorage_CSI460_MM/assets/97249776/2dda99cf-739c-4fdc-a9bf-db6ef65da821)

When I click on the edit text and type in a new item, in this case "Watch the Game", and click "Add to List", you can see that it has been added to the end within the recycler view.
![Capture3](https://github.com/MMahar5/Lab2InternalStorage_CSI460_MM/assets/97249776/0953aa7e-eb8d-4785-9444-29c3f86ed097)

Again, when I show the todo_list.txt file from internal storage, you see the added item "watch the game" is there.
![Capture4](https://github.com/MMahar5/Lab2InternalStorage_CSI460_MM/assets/97249776/08990b42-d221-4871-a839-07ff6fbdd589)

I can leave the application and come back, but you'll see that I intentionally set it up to show the list as blank so I could demonstrate the read functionality. In this screenshot, you can see that the list items are still in our storage, it just needs to be read.
![Capture5](https://github.com/MMahar5/Lab2InternalStorage_CSI460_MM/assets/97249776/698e2274-b113-4d1a-9dbf-c9858bc57a11)

When clicking the "See All Items" button, the list of items is read and loaded back into the recycler view.
![Capture6](https://github.com/MMahar5/Lab2InternalStorage_CSI460_MM/assets/97249776/07e2592a-ccd1-4505-9c60-43ba42572d60)

I also added a delete button that removes the .txt file from the internal storage. I mostly just added this to help while I was creating and testing the application. But here you can see after I click the button and refresh, that the file is gone.
![Capture7](https://github.com/MMahar5/Lab2InternalStorage_CSI460_MM/assets/97249776/55b08f96-e3fe-490d-9a02-c6aa80fa69a0)

The next few slides show some of the code from the main activity that provides the read and write functionality when the buttons are clicked. Below is the onClick listener for the button to add/write a list item and save it to the storage. I set it up so that it actually is presented like a list in the .Txt file, the initial way I did it had it saved as one string.
![Capture8](https://github.com/MMahar5/Lab2InternalStorage_CSI460_MM/assets/97249776/cbf9bf31-4ae7-4554-a8a6-4b7c5da49759)

The code for the Show list and Delete buttons. 
![Capture9](https://github.com/MMahar5/Lab2InternalStorage_CSI460_MM/assets/97249776/3cfe1be0-9ef1-48aa-a11c-fa23e7872128)


