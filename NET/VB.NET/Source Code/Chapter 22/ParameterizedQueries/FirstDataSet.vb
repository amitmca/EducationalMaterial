﻿'------------------------------------------------------------------------------
' <autogenerated>
'     This code was generated by a tool.
'     Runtime Version: 1.1.4322.2032
'
'     Changes to this file may cause incorrect behavior and will be lost if 
'     the code is regenerated.
' </autogenerated>
'------------------------------------------------------------------------------

Option Strict Off
Option Explicit On

Imports System
Imports System.Data
Imports System.Runtime.Serialization
Imports System.Xml


<Serializable(),  _
 System.ComponentModel.DesignerCategoryAttribute("code"),  _
 System.Diagnostics.DebuggerStepThrough(),  _
 System.ComponentModel.ToolboxItem(true)>  _
Public Class FirstDataSet
    Inherits DataSet
    
    Private tableauthors As authorsDataTable
    
    Public Sub New()
        MyBase.New
        Me.InitClass
        Dim schemaChangedHandler As System.ComponentModel.CollectionChangeEventHandler = AddressOf Me.SchemaChanged
        AddHandler Me.Tables.CollectionChanged, schemaChangedHandler
        AddHandler Me.Relations.CollectionChanged, schemaChangedHandler
    End Sub
    
    Protected Sub New(ByVal info As SerializationInfo, ByVal context As StreamingContext)
        MyBase.New
        Dim strSchema As String = CType(info.GetValue("XmlSchema", GetType(System.String)),String)
        If (Not (strSchema) Is Nothing) Then
            Dim ds As DataSet = New DataSet
            ds.ReadXmlSchema(New XmlTextReader(New System.IO.StringReader(strSchema)))
            If (Not (ds.Tables("authors")) Is Nothing) Then
                Me.Tables.Add(New authorsDataTable(ds.Tables("authors")))
            End If
            Me.DataSetName = ds.DataSetName
            Me.Prefix = ds.Prefix
            Me.Namespace = ds.Namespace
            Me.Locale = ds.Locale
            Me.CaseSensitive = ds.CaseSensitive
            Me.EnforceConstraints = ds.EnforceConstraints
            Me.Merge(ds, false, System.Data.MissingSchemaAction.Add)
            Me.InitVars
        Else
            Me.InitClass
        End If
        Me.GetSerializationData(info, context)
        Dim schemaChangedHandler As System.ComponentModel.CollectionChangeEventHandler = AddressOf Me.SchemaChanged
        AddHandler Me.Tables.CollectionChanged, schemaChangedHandler
        AddHandler Me.Relations.CollectionChanged, schemaChangedHandler
    End Sub
    
    <System.ComponentModel.Browsable(false),  _
     System.ComponentModel.DesignerSerializationVisibilityAttribute(System.ComponentModel.DesignerSerializationVisibility.Content)>  _
    Public ReadOnly Property authors As authorsDataTable
        Get
            Return Me.tableauthors
        End Get
    End Property
    
    Public Overrides Function Clone() As DataSet
        Dim cln As FirstDataSet = CType(MyBase.Clone,FirstDataSet)
        cln.InitVars
        Return cln
    End Function
    
    Protected Overrides Function ShouldSerializeTables() As Boolean
        Return false
    End Function
    
    Protected Overrides Function ShouldSerializeRelations() As Boolean
        Return false
    End Function
    
    Protected Overrides Sub ReadXmlSerializable(ByVal reader As XmlReader)
        Me.Reset
        Dim ds As DataSet = New DataSet
        ds.ReadXml(reader)
        If (Not (ds.Tables("authors")) Is Nothing) Then
            Me.Tables.Add(New authorsDataTable(ds.Tables("authors")))
        End If
        Me.DataSetName = ds.DataSetName
        Me.Prefix = ds.Prefix
        Me.Namespace = ds.Namespace
        Me.Locale = ds.Locale
        Me.CaseSensitive = ds.CaseSensitive
        Me.EnforceConstraints = ds.EnforceConstraints
        Me.Merge(ds, false, System.Data.MissingSchemaAction.Add)
        Me.InitVars
    End Sub
    
    Protected Overrides Function GetSchemaSerializable() As System.Xml.Schema.XmlSchema
        Dim stream As System.IO.MemoryStream = New System.IO.MemoryStream
        Me.WriteXmlSchema(New XmlTextWriter(stream, Nothing))
        stream.Position = 0
        Return System.Xml.Schema.XmlSchema.Read(New XmlTextReader(stream), Nothing)
    End Function
    
    Friend Sub InitVars()
        Me.tableauthors = CType(Me.Tables("authors"),authorsDataTable)
        If (Not (Me.tableauthors) Is Nothing) Then
            Me.tableauthors.InitVars
        End If
    End Sub
    
    Private Sub InitClass()
        Me.DataSetName = "FirstDataSet"
        Me.Prefix = ""
        Me.Namespace = "http://www.tempuri.org/FirstDataSet.xsd"
        Me.Locale = New System.Globalization.CultureInfo("en-US")
        Me.CaseSensitive = false
        Me.EnforceConstraints = true
        Me.tableauthors = New authorsDataTable
        Me.Tables.Add(Me.tableauthors)
    End Sub
    
    Private Function ShouldSerializeauthors() As Boolean
        Return false
    End Function
    
    Private Sub SchemaChanged(ByVal sender As Object, ByVal e As System.ComponentModel.CollectionChangeEventArgs)
        If (e.Action = System.ComponentModel.CollectionChangeAction.Remove) Then
            Me.InitVars
        End If
    End Sub
    
    Public Delegate Sub authorsRowChangeEventHandler(ByVal sender As Object, ByVal e As authorsRowChangeEvent)
    
    <System.Diagnostics.DebuggerStepThrough()>  _
    Public Class authorsDataTable
        Inherits DataTable
        Implements System.Collections.IEnumerable
        
        Private columnau_fname As DataColumn
        
        Private columnau_id As DataColumn
        
        Friend Sub New()
            MyBase.New("authors")
            Me.InitClass
        End Sub
        
        Friend Sub New(ByVal table As DataTable)
            MyBase.New(table.TableName)
            If (table.CaseSensitive <> table.DataSet.CaseSensitive) Then
                Me.CaseSensitive = table.CaseSensitive
            End If
            If (table.Locale.ToString <> table.DataSet.Locale.ToString) Then
                Me.Locale = table.Locale
            End If
            If (table.Namespace <> table.DataSet.Namespace) Then
                Me.Namespace = table.Namespace
            End If
            Me.Prefix = table.Prefix
            Me.MinimumCapacity = table.MinimumCapacity
            Me.DisplayExpression = table.DisplayExpression
        End Sub
        
        <System.ComponentModel.Browsable(false)>  _
        Public ReadOnly Property Count As Integer
            Get
                Return Me.Rows.Count
            End Get
        End Property
        
        Friend ReadOnly Property au_fnameColumn As DataColumn
            Get
                Return Me.columnau_fname
            End Get
        End Property
        
        Friend ReadOnly Property au_idColumn As DataColumn
            Get
                Return Me.columnau_id
            End Get
        End Property
        
        Public Default ReadOnly Property Item(ByVal index As Integer) As authorsRow
            Get
                Return CType(Me.Rows(index),authorsRow)
            End Get
        End Property
        
        Public Event authorsRowChanged As authorsRowChangeEventHandler
        
        Public Event authorsRowChanging As authorsRowChangeEventHandler
        
        Public Event authorsRowDeleted As authorsRowChangeEventHandler
        
        Public Event authorsRowDeleting As authorsRowChangeEventHandler
        
        Public Overloads Sub AddauthorsRow(ByVal row As authorsRow)
            Me.Rows.Add(row)
        End Sub
        
        Public Overloads Function AddauthorsRow(ByVal au_fname As String, ByVal au_id As String) As authorsRow
            Dim rowauthorsRow As authorsRow = CType(Me.NewRow,authorsRow)
            rowauthorsRow.ItemArray = New Object() {au_fname, au_id}
            Me.Rows.Add(rowauthorsRow)
            Return rowauthorsRow
        End Function
        
        Public Function GetEnumerator() As System.Collections.IEnumerator Implements System.Collections.IEnumerable.GetEnumerator
            Return Me.Rows.GetEnumerator
        End Function
        
        Public Overrides Function Clone() As DataTable
            Dim cln As authorsDataTable = CType(MyBase.Clone,authorsDataTable)
            cln.InitVars
            Return cln
        End Function
        
        Protected Overrides Function CreateInstance() As DataTable
            Return New authorsDataTable
        End Function
        
        Friend Sub InitVars()
            Me.columnau_fname = Me.Columns("au_fname")
            Me.columnau_id = Me.Columns("au_id")
        End Sub
        
        Private Sub InitClass()
            Me.columnau_fname = New DataColumn("au_fname", GetType(System.String), Nothing, System.Data.MappingType.Element)
            Me.Columns.Add(Me.columnau_fname)
            Me.columnau_id = New DataColumn("au_id", GetType(System.String), Nothing, System.Data.MappingType.Element)
            Me.Columns.Add(Me.columnau_id)
            Me.columnau_fname.AllowDBNull = false
            Me.columnau_id.AllowDBNull = false
        End Sub
        
        Public Function NewauthorsRow() As authorsRow
            Return CType(Me.NewRow,authorsRow)
        End Function
        
        Protected Overrides Function NewRowFromBuilder(ByVal builder As DataRowBuilder) As DataRow
            Return New authorsRow(builder)
        End Function
        
        Protected Overrides Function GetRowType() As System.Type
            Return GetType(authorsRow)
        End Function
        
        Protected Overrides Sub OnRowChanged(ByVal e As DataRowChangeEventArgs)
            MyBase.OnRowChanged(e)
            If (Not (Me.authorsRowChangedEvent) Is Nothing) Then
                RaiseEvent authorsRowChanged(Me, New authorsRowChangeEvent(CType(e.Row,authorsRow), e.Action))
            End If
        End Sub
        
        Protected Overrides Sub OnRowChanging(ByVal e As DataRowChangeEventArgs)
            MyBase.OnRowChanging(e)
            If (Not (Me.authorsRowChangingEvent) Is Nothing) Then
                RaiseEvent authorsRowChanging(Me, New authorsRowChangeEvent(CType(e.Row,authorsRow), e.Action))
            End If
        End Sub
        
        Protected Overrides Sub OnRowDeleted(ByVal e As DataRowChangeEventArgs)
            MyBase.OnRowDeleted(e)
            If (Not (Me.authorsRowDeletedEvent) Is Nothing) Then
                RaiseEvent authorsRowDeleted(Me, New authorsRowChangeEvent(CType(e.Row,authorsRow), e.Action))
            End If
        End Sub
        
        Protected Overrides Sub OnRowDeleting(ByVal e As DataRowChangeEventArgs)
            MyBase.OnRowDeleting(e)
            If (Not (Me.authorsRowDeletingEvent) Is Nothing) Then
                RaiseEvent authorsRowDeleting(Me, New authorsRowChangeEvent(CType(e.Row,authorsRow), e.Action))
            End If
        End Sub
        
        Public Sub RemoveauthorsRow(ByVal row As authorsRow)
            Me.Rows.Remove(row)
        End Sub
    End Class
    
    <System.Diagnostics.DebuggerStepThrough()>  _
    Public Class authorsRow
        Inherits DataRow
        
        Private tableauthors As authorsDataTable
        
        Friend Sub New(ByVal rb As DataRowBuilder)
            MyBase.New(rb)
            Me.tableauthors = CType(Me.Table,authorsDataTable)
        End Sub
        
        Public Property au_fname As String
            Get
                Return CType(Me(Me.tableauthors.au_fnameColumn),String)
            End Get
            Set
                Me(Me.tableauthors.au_fnameColumn) = value
            End Set
        End Property
        
        Public Property au_id As String
            Get
                Return CType(Me(Me.tableauthors.au_idColumn),String)
            End Get
            Set
                Me(Me.tableauthors.au_idColumn) = value
            End Set
        End Property
    End Class
    
    <System.Diagnostics.DebuggerStepThrough()>  _
    Public Class authorsRowChangeEvent
        Inherits EventArgs
        
        Private eventRow As authorsRow
        
        Private eventAction As DataRowAction
        
        Public Sub New(ByVal row As authorsRow, ByVal action As DataRowAction)
            MyBase.New
            Me.eventRow = row
            Me.eventAction = action
        End Sub
        
        Public ReadOnly Property Row As authorsRow
            Get
                Return Me.eventRow
            End Get
        End Property
        
        Public ReadOnly Property Action As DataRowAction
            Get
                Return Me.eventAction
            End Get
        End Property
    End Class
End Class
